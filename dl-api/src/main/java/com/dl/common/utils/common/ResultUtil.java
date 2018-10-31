package com.dl.common.utils.common;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.model.base.ResponseData;

public class ResultUtil {
	
	/**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static String success(Object object){
        ResponseData ResponseData = new ResponseData();
        ResponseData.setCode(ResponseCodeEnum.SUCCESS.code);
        ResponseData.setDesc(ResponseCodeEnum.SUCCESS.desc);
        ResponseData.setObject(object);
        return JSONObject.toJSONString(ResponseData);
    }
 
    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static String success(){
        return success(null);
    }
    
    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static String error(){
        return error(ResponseCodeEnum.FALSE);
    }
    
    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static String error(String code){
        ResponseData ResponseData = new ResponseData();
        ResponseData.setCode(code);
        ResponseData.setDesc(ResponseCodeEnum.getMsg(code));
        ResponseData.setObject(null);
        return JSONObject.toJSONString(ResponseData);
    }
    
    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static String error(String code,String desc){
        ResponseData ResponseData = new ResponseData();
        ResponseData.setCode(code);
        ResponseData.setDesc(desc);
        ResponseData.setObject(null);
        return JSONObject.toJSONString(ResponseData);
    }
 
    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static String error(ResponseCodeEnum codeEnum){
        ResponseData ResponseData = new ResponseData();
        ResponseData.setCode(codeEnum.getCode());
        ResponseData.setDesc(codeEnum.getDesc());
        ResponseData.setObject(null);
        return JSONObject.toJSONString(ResponseData);
    }
    
}
