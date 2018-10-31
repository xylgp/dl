package com.dl.common.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.service.user.UserAttentionService;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("user")
public class UserAttentionController {
	
	@Autowired
	private UserAttentionService attentionService;
	
	/**
	 * 关注用户 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("attention")
	public String attention(@RequestBody UserRequest request){
		attentionService.attention(request);
		return ResultUtil.success();
	}
	
	@ResponseBody
	@RequestMapping("cancelAttention")
	public String cancelAttention(@RequestBody UserRequest request){
		attentionService.cancelAttention(request);
		return ResultUtil.success();
	}
	
	@ResponseBody
	@RequestMapping("attentionList")
	public String attentionList(@RequestBody UserRequest request){
		return ResultUtil.success(attentionService.attentionList(request));
	}
	
	@ResponseBody
	@RequestMapping("fansList")
	public String fansList(@RequestBody UserRequest request){
		return ResultUtil.success(attentionService.fansList(request));
	}
}
