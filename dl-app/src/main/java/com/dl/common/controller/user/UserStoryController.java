package com.dl.common.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.enums.StoryStatusEnum;
import com.dl.common.service.story.StoryService;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("user")
public class UserStoryController {

	@Autowired
	private StoryService storyService;
	
	/**
	 * 用户审核通过的故事列表
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkSuccessList")
	public String checkSuccessList(@RequestBody UserRequest userRequest){
		return ResultUtil.success(storyService.selectStoryListByUserAndStatus(userRequest.getUserId(), Integer.parseInt(StoryStatusEnum.SUCCESS_CHECK.status)));
	}
	
	/**
	 * 用户审核不通过的故事列表
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkFailList")
	public String checkFailList(@RequestBody UserRequest userRequest){
		return ResultUtil.success(storyService.selectStoryListByUserAndStatus(userRequest.getUserId(), Integer.parseInt(StoryStatusEnum.FLASE_CHECK.status)));
	}
	
	/**
	 * 用户待审核的故事列表
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("unCheckList")
	public String unCheckList(@RequestBody UserRequest userRequest){
		return ResultUtil.success(storyService.selectStoryListByUserAndStatus(userRequest.getUserId(), Integer.parseInt(StoryStatusEnum.WAIT_CHECK.status)));
	}
	
}
