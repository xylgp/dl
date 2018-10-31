package com.dl.common.framework.asyncTask;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.config.MsgTemplateProps;
import com.dl.common.framework.logger.LoggerUtil;
import com.dl.common.framework.threadpool.BaseThreadTask;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.story.Story;
import com.dl.common.model.entity.story.StoryAttention;
import com.dl.common.model.entity.user.User;
import com.dl.common.service.story.StoryAttentionService;
import com.dl.common.service.story.StoryService;
import com.dl.common.service.user.UserAttentionService;
import com.dl.common.service.user.UserService;

public class AsyncTaskThread extends BaseThreadTask{

	@Autowired
	private StoryAttentionService storyAttentionService;
	@Autowired
	private UserAttentionService userAttentionService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoryService storyService;
	
	@Override
	public void run() {
		LoggerUtil.info("异步任务队列开始");
		while (!isShutdown) {
			Object obj = null;
			try {
				//从异步任务队列获取队列
				AsyncTask task = AsyncTaskQueue.take(10);
				switch (task.getTaskEnum()) {
				case ASYNC_PUT_ATTENTION: //被关注人发布消息
					Story story = (Story) task.getParam();
					story = storyService.getById(story.getId());
					//查询发布人信息
					User user = userService.getById(story.getUserId());
					//获取发布人的关注人列表
					UserRequest request = new UserRequest();
					request.setAttentionId(story.getUserId());
					List<User> fansList = userAttentionService.fansList(request);
					//循环构建粉丝关注
					String title = String.format(MsgTemplateProps.UPLOAD_STORY, user.getNickName(),story.getTitle());
					List<StoryAttention> attentionList = new ArrayList<>();
					for(User fans : fansList){
						StoryAttention storyAttention = new StoryAttention();
						storyAttention.setUserId(story.getUserId());
						storyAttention.setAttentionId(fans.getId());
						storyAttention.setTitle(title);
						storyAttention.setStoryId(story.getId());
						storyAttention.setType("1");
						attentionList.add(storyAttention);
					}
					if(attentionList.size() > 0){
						storyAttentionService.batchInsert(attentionList);
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				LoggerUtil.error("异步任务处理异常,异步任务："+JSONObject.toJSONString(obj), e);
			}
			
		}
		
	}

}
