package com.dl.common.handler.story;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dl.common.framework.asyncTask.AsyncTask;
import com.dl.common.framework.asyncTask.AsyncTask.AsyncTaskEnum;
import com.dl.common.framework.asyncTask.AsyncTaskQueue;
import com.dl.common.framework.exception.DlException;
import com.dl.common.handler.story.convert.StoryConvert;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.model.constant.Constant;
import com.dl.common.model.entity.story.CheckRecord;
import com.dl.common.model.entity.story.Story;
import com.dl.common.model.entity.story.StoryChannel;
import com.dl.common.model.entity.story.StoryOutline;
import com.dl.common.model.enums.StoryStatusEnum;
import com.dl.common.service.story.CheckRecordService;
import com.dl.common.service.story.StoryChannelService;
import com.dl.common.service.story.StoryOutlineService;
import com.dl.common.service.story.StoryService;
import com.dl.common.service.user.UserService;
import com.dl.common.utils.common.UIDUtils;

@Component
public class StoryHandler {
	
	@Autowired
	StoryService storyService;
	@Autowired
	StoryOutlineService storyOutlineService;
	@Autowired
	StoryChannelService storyChannelService; 
	@Autowired
	CheckRecordService checkRecordService;
	@Autowired
	UserService userService;
	
	/**
	 * 新增故事
	 */
	@Transactional
	public void insertStory(StoryRequest request){
		String storyId = UIDUtils.generateID();
		if(request.getLevelNum().equals("0")){
			request.setRootId(storyId);
		}
		//存储故事
		Story story = StoryConvert.convertStory(request);
		story.setId(storyId);
		story.setStatus(StoryStatusEnum.WAIT_CHECK.status);
		storyService.insert(story);
		//存储故事板块消息
		List<StoryChannel> channelList = StoryConvert.convertStoryChannel(storyId, request);
		storyChannelService.insert(channelList);
		//存储故事层级关系
		StoryOutline storyOutline = StoryConvert.convertStoryOutline(storyId, request);
		storyOutlineService.insert(storyOutline);
		
	}
	
	/**
	 * 查询故事大纲
	 * @param storyId
	 */
	@Transactional
	public List<StoryResponse> storyOutline(String rootId){
		return storyOutlineService.storyOutline(rootId);
	}
	
	/**
	 * 根据状态查询故事列表
	 * @param storyReq
	 * @return
	 */
	@Transactional
	public List<StoryResponse> checkList(StoryRequest storyReq){
		if(storyReq.getPageSize() == 0) storyReq.setPageSize(10);
		storyReq.setIndex(storyReq.getNowPage() * storyReq.getPageSize());
		return storyService.checkList(storyReq);
	}
	
	/**
	 * 审核故事
	 * @param storyReq
	 */
	@Transactional
	public void checkStory(StoryRequest storyReq){
		//保存审核记录
		CheckRecord checkRecord = StoryConvert.convertCheckRecord(storyReq);
		checkRecordService.insert(checkRecord);
		//修改故事审核结果
		Story story = new Story();
		story.setId(storyReq.getId());
		story.setStatus(storyReq.getStatus());
		story.setUpdateTime(new Date());
		storyService.update(story);
		//判断板块是否被修改
		if(null != storyReq.getChannelList()){
			//删除原有记录
			storyChannelService.deleteByStoryId(storyReq.getId());
			//保存最新故事
			List<StoryChannel> channelList = StoryConvert.convertStoryChannel(storyReq.getId(), storyReq);
			storyChannelService.insert(channelList);
		}
		//如果审核通过异步生成关注列表
		if(storyReq.getStatus().equals(StoryStatusEnum.SUCCESS_CHECK.status))
			AsyncTaskQueue.offer(new AsyncTask(AsyncTaskEnum.ASYNC_PUT_ATTENTION, story));
	}
	
	/**
	 * 查询故事内容
	 * @param id
	 * @param rootId
	 * @return
	 */
	@Transactional
	public Map<String, Object> storyContent(String id,String rootId){
		Map<String, Object> dataMap = new HashMap<>();
		//查询故事静态信息：标题、内容、背景、是否显示结尾
		Story story = storyService.getStoryStaticContent(id);
		//查询故事动态信息：用户昵称、图像，点赞数、收藏数、关注数、阅读数、打赏数
		StoryResponse response = storyService.getStoryDynamicContent(id);
		//非空校验
		if(story == null || response == null){
			throw new DlException(ResponseCodeEnum.STORY_NOT_EXIST.code);
		}
		//查询故事大纲
		dataMap.put("storyOutline",storyOutlineService.storyOutline(id));
		response = StoryConvert.convertStoryResponse(story, response);
		dataMap.put("story", response);
		return dataMap;
	}
	
	@Transactional
	public Map<String, Object> storyContentDynamic(String id,String rootId){
		Map<String, Object> dataMap = new HashMap<>();
		//查询故事动态信息：用户昵称、图像，点赞数、收藏数、关注数、阅读数、打赏数
		StoryResponse response = storyService.getStoryDynamicContent(id);
		//非空校验
		if(response == null){
			throw new DlException(ResponseCodeEnum.STORY_NOT_EXIST.code);
		}
		//查询故事大纲
		dataMap.put("storyOutline",storyOutlineService.storyOutline(rootId));
		response = StoryConvert.convertStoryResponse(new Story(), response);
		dataMap.put("story", response);
		return dataMap;
	}
	
	
	
}
