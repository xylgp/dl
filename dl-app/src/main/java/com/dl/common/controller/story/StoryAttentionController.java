package com.dl.common.controller.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.service.story.StoryAttentionService;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("story")
public class StoryAttentionController {
	
	@Autowired
	private StoryAttentionService storyAttentionService;
	
	@ResponseBody
	@RequestMapping("attentionList")
	public String storyAttentionList(@RequestBody StoryRequest storyRequest){
		return ResultUtil.success(storyAttentionService.selectListByUserId(storyRequest));
	}
}
