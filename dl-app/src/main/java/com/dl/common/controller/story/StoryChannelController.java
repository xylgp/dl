package com.dl.common.controller.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dl.common.handler.story.StoryChannelHandler;
import com.dl.common.model.app.req.StoryListRequest;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("/storyChannel")
public class StoryChannelController {
	
	@Autowired
	private StoryChannelHandler storyChannelHandler;
	
	@ResponseBody
	@RequestMapping("batchStore")
	public String batchStoreStoryRedis(){
		return ResultUtil.success(storyChannelHandler.batchStoreStoryRedis());
	}
	
	@ResponseBody
	@RequestMapping("listByPage")
	public String listByPage(@RequestBody StoryListRequest listRequest){
		return ResultUtil.success(storyChannelHandler.selectStoryListByPage(listRequest));
	}
}
