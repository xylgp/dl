package com.dl.common.model.app.req;

import java.util.Date;
import java.util.List;

import com.dl.common.model.base.BaseEntity;
import com.dl.common.model.entity.story.Channel;
import com.dl.common.model.entity.user.User;

public class StoryResponse extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 关注标题
	 */
	private String attentionTitle;
	
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
	 * 是否显示结尾（0：否，1：是）
	 */
	private String isEndingShow;
	
	 /**
     * 数据库字段信息:clickCount INT(10)
     */
	private String clickCount;

    /**
     * 数据库字段信息:collectCount INT(10)
     */
	private String collectCount;

    /**
     * 数据库字段信息:followCount INT(10)
     */
	private String followCount;

    /**
     * 数据库字段信息:readCount INT(10)
     */
	private String readCount;

    /**
     * 数据库字段信息:rewardCount INT(10)
     */
	private String rewardCount;
	
	/**
	 * 父新闻ID
	 */
	private String parentTitle;
	
	/**
	 * 板块集合
	 */
	private List<String> channelList;
	
	/**
	 * 用户相关信息
	 */
	private User user;
	
	private Date createTime;
	
	private List<Channel> channels; 

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

	public String getIsEndingShow() {
		return isEndingShow;
	}

	public void setIsEndingShow(String isEndingShow) {
		this.isEndingShow = isEndingShow;
	}

	public String getClickCount() {
		return clickCount;
	}

	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
	}

	public String getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(String collectCount) {
		this.collectCount = collectCount;
	}

	public String getFollowCount() {
		return followCount;
	}

	public void setFollowCount(String followCount) {
		this.followCount = followCount;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getRewardCount() {
		return rewardCount;
	}

	public void setRewardCount(String rewardCount) {
		this.rewardCount = rewardCount;
	}

	public String getParentTitle() {
		return parentTitle;
	}

	public void setParentTitle(String parentTitle) {
		this.parentTitle = parentTitle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAttentionTitle() {
		return attentionTitle;
	}

	public void setAttentionTitle(String attentionTitle) {
		this.attentionTitle = attentionTitle;
	}
	
 }
