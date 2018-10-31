package com.dl.common.controller.story;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dl.common.framework.exception.DlException;
import com.dl.common.handler.story.ChannelHandler;
import com.dl.common.model.app.req.ChannelRequest;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping(value = "/channel")
public class ChannelController {
	
	@Autowired
	private ChannelHandler channelHandler;
	
	/**
	 * 获取默认的板块列表：存储缓存，如果缓存不存在，查询后存储
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="defaultChannel",method=RequestMethod.POST)
	public String getDefaultChannelList(){
		return ResultUtil.success(channelHandler.getDefaultChannelList());
	}
	
	/**
	 * 获取全部启用的板块列表：存储缓存，如果缓存不存在，查询后存储
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="fullChannel",method=RequestMethod.POST)
	public String getFullChannelList(){
		return ResultUtil.success(channelHandler.getFullChannelList());
	}
	
	/**
	 * 保存用户自定义板块
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="insertChannel",method=RequestMethod.POST)
	public String insertUserChannelList(@RequestBody ChannelRequest channelReq){
		channelHandler.insertUserChannelList(channelReq.getUserId(), channelReq.getChannelList());
		return ResultUtil.success();
	}
	
	/**
	 * 获取用户自定义板块
	 * @param channelReq
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="userChannel",method=RequestMethod.POST)
	public String getUserChannelList(@RequestBody ChannelRequest channelReq){
		return ResultUtil.success(channelHandler.getUserChannelList(channelReq.getUserId()));
	}
	
	@ResponseBody
	@RequestMapping(value="testChannel",method=RequestMethod.POST)
	public String testChannel(@RequestBody ChannelRequest channelReq){
		if(StringUtils.isEmpty(channelReq.getUserId())){
			throw new DlException(ResponseCodeEnum.REQ_PARAM_EMPTY.code);
		}
		channelHandler.test(channelReq.getUserId());
		return ResultUtil.success();
	}
}
