/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：Story.java
  * 作    者：刘广平
  * 创建日期：2018-9-3
  * </pre>
  */
package com.dl.common.model.entity.story;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_story
 * </pre>
 */
public class Story extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：版本号
     * 数据库字段信息:version VARCHAR(40)
     */
	private String version;

    /**
     * 字段名称：用户ID
     * 数据库字段信息:userId BIGINT(19)
     */
	private String userId;

    /**
     * 字段名称：标题
     * 数据库字段信息:title VARCHAR(50)
     */
	private String title;

    /**
     * 字段名称：根故事id(如果是根故事，值为0)
     * 数据库字段信息:rootId BIGINT(19)
     */
	private String rootId;

    /**
     * 字段名称：内容第一段
     * 数据库字段信息:content1 TEXT(65535)
     */
	private String content1;

    /**
     * 字段名称：第一段字体颜色
     * 数据库字段信息:color1 VARCHAR(20)
     */
	private String color1;

    /**
     * 字段名称：内容第二段
     * 数据库字段信息:content2 TEXT(65535)
     */
	private String content2;

    /**
     * 字段名称：第二段字体颜色
     * 数据库字段信息:color2 VARCHAR(20)
     */
	private String color2;

    /**
     * 字段名称：内容第三段
     * 数据库字段信息:content3 TEXT(65535)
     */
	private String content3;

    /**
     * 字段名称：第三段字体颜色
     * 数据库字段信息:color3 VARCHAR(20)
     */
	private String color3;

    /**
     * 字段名称：背景(颜色/图片)
     * 数据库字段信息:background VARCHAR(100)
     */
	private String background;

    /**
     * 字段名称：状态（0：待审核，1：审核中，2：审核通过，3：审核不通过）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：是否允许显示（0：否，1：是）
     * 数据库字段信息:allowShow INT(10)
     */
	private String allowShow;

    /**
     * 字段名称：是否显示结尾（0：否，1：是）
     * 数据库字段信息:isEndingShow INT(10)
     */
	private String isEndingShow;

    /**
     * 字段名称：点赞数
     * 数据库字段信息:clickCount INT(10)
     */
	private String clickCount;

    /**
     * 字段名称：收藏数
     * 数据库字段信息:collectCount INT(10)
     */
	private String collectCount;

    /**
     * 字段名称：关注数
     * 数据库字段信息:followCount INT(10)
     */
	private String followCount;

    /**
     * 字段名称：阅读数
     * 数据库字段信息:readCount INT(10)
     */
	private String readCount;

    /**
     * 字段名称：打赏数
     * 数据库字段信息:rewardCount INT(10)
     */
	private String rewardCount;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    /**
     * 字段名称：修改时间
     * 数据库字段信息:updateTime DATETIME(19)
     */
	private Date updateTime;

    public Story() {
    }	

	

	public String getVersion() {
        return this.version;
    }


	public void setVersion(String version) {
        this.version = version;
    }

	

	public String getUserId() {
        return this.userId;
    }


	public void setUserId(String userId) {
        this.userId = userId;
    }

	

	public String getTitle() {
        return this.title;
    }


	public void setTitle(String title) {
        this.title = title;
    }

	

	public String getRootId() {
        return this.rootId;
    }


	public void setRootId(String rootId) {
        this.rootId = rootId;
    }

	

	public String getContent1() {
        return this.content1;
    }


	public void setContent1(String content1) {
        this.content1 = content1;
    }

	

	public String getColor1() {
        return this.color1;
    }


	public void setColor1(String color1) {
        this.color1 = color1;
    }

	

	public String getContent2() {
        return this.content2;
    }


	public void setContent2(String content2) {
        this.content2 = content2;
    }

	

	public String getColor2() {
        return this.color2;
    }


	public void setColor2(String color2) {
        this.color2 = color2;
    }

	

	public String getContent3() {
        return this.content3;
    }


	public void setContent3(String content3) {
        this.content3 = content3;
    }

	

	public String getColor3() {
        return this.color3;
    }


	public void setColor3(String color3) {
        this.color3 = color3;
    }

	

	public String getBackground() {
        return this.background;
    }


	public void setBackground(String background) {
        this.background = background;
    }

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

	

	public String getAllowShow() {
        return this.allowShow;
    }


	public void setAllowShow(String allowShow) {
        this.allowShow = allowShow;
    }

	

	public String getIsEndingShow() {
        return this.isEndingShow;
    }


	public void setIsEndingShow(String isEndingShow) {
        this.isEndingShow = isEndingShow;
    }

	

	public String getClickCount() {
        return this.clickCount;
    }


	public void setClickCount(String clickCount) {
        this.clickCount = clickCount;
    }

	

	public String getCollectCount() {
        return this.collectCount;
    }


	public void setCollectCount(String collectCount) {
        this.collectCount = collectCount;
    }

	

	public String getFollowCount() {
        return this.followCount;
    }


	public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

	

	public String getReadCount() {
        return this.readCount;
    }


	public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

	

	public String getRewardCount() {
        return this.rewardCount;
    }


	public void setRewardCount(String rewardCount) {
        this.rewardCount = rewardCount;
    }

	
	public Date getCreateTime() {
        return this.createTime;
    }


	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


	
	public Date getUpdateTime() {
        return this.updateTime;
    }


	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}