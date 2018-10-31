package com.dl.common.framework.redis.vo;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.dl.common.utils.common.UIDUtils;

public class QueryBaseVo implements Serializable{

	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//id集合
	private List<String> idList;
	//起始id
	private String startId;
	//结束id
	private String endId;
	
	/**
	 * 获取最小Id，如果为空，默认用当前时间生成ID
	 * @return
	 */
	public String getStartIdNullDefault(){
		if(StringUtils.isEmpty(startId)){
			return UIDUtils.generateID();
		}
		return startId;
	}
	
	/**
	 * 最大时间戳，如果为空，默认使用2200-12-30 23:59:59分生成的ID
	 * @return
	 */
	public String getEndIdNullDefault(){
		if(StringUtils.isEmpty(endId)){
			return UIDUtils.generateID();
		}
		return endId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	public String getStartId() {
		return startId;
	}

	public void setStartId(String startId) {
		this.startId = startId;
	}

	public String getEndId() {
		return endId;
	}

	public void setEndId(String endId) {
		this.endId = endId;
	}
	
}
