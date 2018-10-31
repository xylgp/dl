package com.dl.common.model.base;

import com.dl.common.model.enums.CodeEnum;
import java.io.Serializable;

/**
 * 返回结果
 * @author shb
 *
 */
public class ResponseData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	public ResponseData() {
	}
	
	public ResponseData(CodeEnum codeEnum) {
		this.code = codeEnum.code;
		this.desc = codeEnum.Desr;
	}

	public ResponseData(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}

	public ResponseData(CodeEnum codeEnum,Object object) {
		this.code = codeEnum.code;
		this.desc = codeEnum.Desr;
		this.object = object;
	}

	/**
	 * 操作码
	 */
	private String code;
	
	/**
	 * 描述信息
	 */
	private String desc;
	
	/**
	 * 对象
	 */
	private Object object;
	/**
	 * 当前页数
	 */
	private Integer page;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		this.desc = CodeEnum.parse(code);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
