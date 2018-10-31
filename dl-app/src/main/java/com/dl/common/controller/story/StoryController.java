package com.dl.common.controller.story;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dl.common.handler.story.StoryHandler;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	StoryHandler storyHandler;
	
	/**
	 * 新增故事
	 * @param request
	 * @param storyRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="insertStory",method=RequestMethod.POST)
	public String insertStory(@RequestBody StoryRequest storyRequest){
		//校验参数
		storyHandler.insertStory(storyRequest);
		return ResultUtil.success();
	}
	
	/**
	 * 查询故事大纲
	 * @param request
	 * @param storyRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="storyOutline",method=RequestMethod.POST)
	public String storyOutline(HttpServletRequest request,@RequestBody StoryRequest storyRequest){
		return ResultUtil.success(storyHandler.storyOutline(storyRequest.getRootId()));
	}
	
	/**
	 * 查询待审核列表
	 * @param request
	 * @return
	 */
	@ResponseBody
//	@RequiresPermissions(value="APP:STORY:SELECT")
	@RequestMapping(value="checkList",method=RequestMethod.POST)
	public String checkList(HttpServletRequest request,@RequestBody StoryRequest storyRequest){
		return ResultUtil.success(storyHandler.checkList(storyRequest));
	}
	
	/**
	 * 审核故事
	 * @param request
	 * @return
	 */
	@ResponseBody
//	@RequiresPermissions(value="APP:STORY:CHECK")
	@RequestMapping(value="checkStory",method=RequestMethod.POST)
	public String checkStory(HttpServletRequest request,@RequestBody StoryRequest storyRequest){
		storyHandler.checkStory(storyRequest);
		return ResultUtil.success();
	}
	
	/**
	 * 故事详情：包含静态内容、动态内容、故事大纲
	 * @param request
	 * @param storyRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="storyContent",method=RequestMethod.POST)
	public String storyContent(HttpServletRequest request,@RequestBody StoryRequest storyRequest){
		return ResultUtil.success(storyHandler.storyContent(storyRequest.getId(), storyRequest.getRootId()));
	}
	
	@ResponseBody
	@RequestMapping(value="storyContentDyanmic",method=RequestMethod.POST)
	public String storyContentDyanmic(HttpServletRequest request,@RequestBody StoryRequest storyRequest){
		return ResultUtil.success(storyHandler.storyContentDynamic(storyRequest.getId(), storyRequest.getRootId()));
	}
}
