package com.dl.common.model.app.req;

import java.util.List;
import com.dl.common.model.base.BaseReqEntity;

public class StoryRequest extends BaseReqEntity{

	private static final long serialVersionUID = 1L;
	
	/**
     * 字段名称：标题
     */
	private String title;

    /**
     * 字段名称：根故事id(如果是根故事，值为0)
     */
	private String rootId;
	
	/**
	 * 字段名称：父故事id
	 */
	private String parentId;
	
	/**
	 * 字段名称：所在层级
	 */
	private String levelNum;

    /**
     * 字段名称：内容第一段
     */
	private String content1;

    /**
     * 字段名称：第一段字体颜色
     */
	private String color1;

    /**
     * 字段名称：内容第二段
     */
	private String content2;

    /**
     * 字段名称：第二段字体颜色
     */
	private String color2;

    /**
     * 字段名称：内容第三段
     */
	private String content3;

    /**
     * 字段名称：第三段字体颜色
     */
	private String color3;

    /**
     * 字段名称：背景(颜色/图片)
     */
	private String background;
	/**
	 * 是否允许显示（0：否，1：是）
	 */
	private String allowShow;
	/**
	 * 状态（0：待审核，1：审核中，2：审核通过，3：审核不通过）
	 */
	private String status;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 是否显示结尾
	 */
	private String isEndingShow;
	
	/**
	 * 板块集合
	 */
	private List<String> channelList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLevelNum() {
		return levelNum;
	}

	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getColor3() {
		return color3;
	}

	public void setColor3(String color3) {
		this.color3 = color3;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<String> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<String> channelList) {
		this.channelList = channelList;
	}

	public String getAllowShow() {
		return allowShow;
	}

	public void setAllowShow(String allowShow) {
		this.allowShow = allowShow;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsEndingShow() {
		return isEndingShow;
	}

	public void setIsEndingShow(String isEndingShow) {
		this.isEndingShow = isEndingShow;
	}
	
 }
