package com.dl.common.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册接口
 * @author Levi.liu
 */
@Controller
@RequestMapping("register")
public class RegisterController {
	
	@RequestMapping("username")
	public String usreNameRegister(){
		
		return null;
	}
	
	@RequestMapping("qq")
	public String qqRegister(){
		
		return null;
	}
	
	@RequestMapping("wx")
	public String wxRegister(){
		
		return null;
	}
	
	@RequestMapping("wb")
	public String wbRegister(){
		
		return null;
	}
}
