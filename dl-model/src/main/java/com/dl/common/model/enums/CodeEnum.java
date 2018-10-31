package com.dl.common.model.enums;

import org.apache.commons.lang3.StringUtils;


/**
 * 操作码定义--6位数
 * 
 * 公共:000000--099999
 * 新闻:100000--199999
 * 支付:200000--299999
 * 个人中心：300000--399999
 * 搜索:400000--499999
 * 网易云信:500000--599999
 * 非法请求:600000--699999
 * 消息APP不提示:700000--799999
 * @author shb
 *
 */
public enum CodeEnum {
	
	SUCCESS("000000","操作成功"),
	
	FALSE("000001","操作失败"),
	
	NOSELECT("000003","未查询到数据"),
	
	NOLatitudeLongitude("000004","获取经纬度失败"),
	
	NOSELECTSECTION("000005","未查询到板块信息"),
	
	INFOALREADY("000006","该标签已存在,不能添加"),
	
	NOPARAM("000007","传入参数异常"),
	
	MOBILENO_Format("000008","手机号码格式不正确"),
	
	MOBILENO_REGISTERED("100008","该手机号码已注册"),

	validCode_error("000009","验证码有误"),
	
	validCode_expire("000010","验证码过期"),
	
	validCode_Exceed_Num("000011","获取验证码次数超过限制"),
	
	PICNOTYPE("000012","图片格式不正确"),
	
	SMS_SUCCESS("000013","短信发送成功"),
	
	SMS_Filde("000014","短信发送失败"),
	
	PARAM_ISBLANK("000015","参数为空"),
	
	PARAM_ISBLANK_NULL("000016","type和content必须同时传入"),
	
	MOBILE_LOGIN_ERROR("000017","登录信息过期或不存在，请重新登录"),
	
	USER_NOT_APPMANAGER("000018","当前用户非APP管理员"),
	
	USER_VERSION_ERROR("000019","领取有变动,请刷新界面再领取"),
	
	MESSAGE_CONENT_ERROR("000020","留文字字数4-200"),
	
	NO_USER("000021","用户不存在"),
	
	DATE_NOT_BEFORE("000022","设定时间不能晚于当前时间"),
	
	ROOM_NOROLE_EDIT("000023","无权限修改"),
	
	SMS_GET("000024","未获取短信信息"),
	
	IMG_CODE("000025","图形验证码错误"),
	
	IMG_CODE_ERROR("000026","图形验证码已失效，重新获取"),
	
	REPEAT_SECTION("000027","版块名重复"),
	
	NO_SECTION("000028","版块不存在"),
	
	IN_BLACKLIST("000029","您已进入黑名单,无法操作!"),
	
	EXIST_FRAMEID("000030","不能重复设置框架"),
	
	LACK_MONEY("000031","留言有赏资金不足"),
	
	MONEY_USERED_UP("000032","红包已领完,下次再来"),
	
	CANCEL_MESSAGE_TOP("000033","留言已领赏,不能取消置顶"),
	
	VERSION_ERROR("000034","版本过旧,请重启软件等待更新!"),
	
	APPVERSION_NEWEST("000035","已经是最新版本"),
	
	ZFB_ERROR("000036","该账号已经被使用"),
	
	REQUEST_ILLEGAL("000037","系统异常"),
	
	CANCEL_BROKE_TOP("000038","爆料已领赏,不能取消置顶"),
	
	APP_TIME_ERROR("000039","时间异常"),
	
	GATHER_USED("100001","围观已使用"),
	
	VOTENOTEXIST("100002","新闻的问题不存在"),
	
	TITLENOTEXIST("100003","主新闻标题不存在"),
	
	ISNOTNUMBER("100004","金额必须大于等于零"),
	
	HAS_APPLY("100005","已经申请过奖励"),
	
	UNREACH_APPLY("100006","不满足申请条件"),
	
	NEWSCOLLECTIONNOT("100007","不能重复收藏"),
	
	NEWS_ROOM_NOTCOLSE("100008","最新的嘉宾室还没有结束"),
	
	NEWS_ROOM_NOEXIST("100009","新闻不存在嘉宾室"),
	
	NODELETE("100010","审核中不能删除"),
	
	QUERYBYID("100011","该数据不存在,不能删除"),
	
	SENSITIVEWORD("100012","文字内容存在敏感词"),
	
	HAS_FANS_GATHER("100013","粉丝邀请已使用"),
	
	NO_FANS_GATHER("100014","没有粉丝"),
	
	NO_TOPMESSAGE("100015","置顶已达上限"),
	
	MSGHASUSERED("100016","该留言已选为投票"),

	NEWSLIKENOT("100017","不能重复点赞"),
	NEWSUNLIKENOT("100018","不能重复拍砖"),
	
	NOATTENTION("100019","不能关注自己"),
	
	NOSHIELD("100020","不能屏蔽自己"),
	
	REPEATATTENTION("100021","不能重复关注"),
	
	REPEATSHIELD("100022","不能重复屏蔽"),
	
	LACKVOTES("100023","问题选项数量不够"),
	
	VOTENOTREP("100024","您已投票"),
	
	REPEATREPART("100025","不能重复举报"),
	
	
	NO_QUESTIONNAIRE("100026","不存在的调查问卷"),
	
	HAVE_QUESTIONNAIRE("100027","已存在调查问卷"),
	
	HAVE_QUESTION_NOTITLE("100028","已存在调查问卷,不存在问卷标题"),
	
	SORT_QUESTION_ISNULL("100029","问题序号不能为空"),
	
	SORT_QUESTION_REPEAT("100030","问题序号不能重复"),
	
	VOTE_MUST_IS("100031","必填选项不能为空"),
	
	EXIST_FRAMECONTENT("100032","该栏目已使用,请重新选择!"),
	
	NOORDER("200001","订单不存在"),
	
	PAYPWD_FALSE("200002","支付密码错误"),
	
	NOBALANCE("200003","可用余额不足"),
	
	ORDERFALSE("200004","订单异常"),
	
	QUESTION_SUCCESS("200005","问题已回答"),
	
	QUESTION_FALSE("200006","问题未回答"),
	
	NO_QUESTION("200007","问题不存在"),
	
	NO_NEWS("200008","新闻不存在"),
	
	DONATION_MAX("200009","捐款金额达到上限"),
	
	NO_GATHERRULES("200010","围观规则有误"),
	
//	PAY_SUCCESS("200011","支付成功"),
	
	PAY_FALSE("200012","支付失败"),
	
	ORDER_NOPAY("200013","已支付"),
	
	QUESTION_NOANSWER("200014","用户不能回答"),
	
	ZFB_SING_SUCCESS("200015","支付宝签名成功"),
	
	ZFB_SING_FALSE("200016","支付宝签名失败"),
	
	ZFB_NOTIFY_FALSE("200017","支付宝验签失败"),
	
	PAY_NOPWD("200018","支付密码未设置"),
	
	PAYOPWD_FALSE("200019","旧密码不正确"),
	
	PAYNPWD_FALSE("200020","新密码格式不正确"),
	
	ZFB_CALLBACK_FALSE("200021","支付宝回调失败"),
	
	ZFB_CALLBACK_NOPAY("200022","未付款交易超时关闭"),
	
	WX_SIGN_PREPAYID("200023","获取prepayId失败"),
	
	WX_SIGN_TOKEN("200024","获取不到Token"),
	
	PAY_BALANCE("200025","付款金额异常"),
	
	PREPAY_ORDER("200026","待付款订单"),
	
	WX_SING_FALSE("200027","微信签名失败"),
	
	WX_CONNECT_FALSE("200028","微信通讯失败"),
	
	WX_TRANSACTION_FALSE("200030","微信交易失败"),
	
	WX_TRANSACTION_SUCCESS("200031","微信交易成功"),
	
	PAYOPWD_REPEAT("200032","新密码与旧密码不能一样"),
	
	NO_ACCOUNT("200033", "没有收款账户"),
	
	QUESTION_PASS("200034", "问题过时"),
	
	LISTEN_MAX("200035", "偷听人数达到上限"),
	
	WITHDROW_WX("200036", "实际提现金额不能少于一元"),
	
	AWARDERROR("200037","不能打赏给自己"),
	
	WITHDROW_MIN("200038", "提现金额太少"),
	
	PERCENT_FALSE("200039", "分成比例异常"),
	
	LOCK_ORDER("200040", "订单锁定"),
	
	AWARD_FALSE("200041","打赏失败"),
	
	AWARD_SUCCESS("200042","已领赏"),
	
	AWARD_MIN("200043","打赏金额不足"),
	
	AWARD_LEAD_END("200044","红包已经领完"),
	
	COUPON_NOT_USE("300000","该劵已不能使用"),

	USER_UNBUNDLED_POP("300010","你有未完成的提现订单，是否解绑。"),//解绑操作提示

	SEARCHEXCEPTION("400002","搜索系统异常"),
	
	SEARCHCONNENT("400003","搜索系统调用接口失败"),
	
	ACCID_NULL("500001","accid不能为空"),

	PARAM_ILLEGAL("500002","请求云信参数不合法"),
	
	UPDATE_UINFO("500003","用户云信信息修改成功"),
	
	UPDATE_ROOM_ONLINE("500004","请求云信矫正人数错误"),
	
	QUERY_USET_INFO("500005","云信用户不存在，或已锁定"),
	
	ROOM_ENDTIME("500006","房间过时"),
	
//----------------------------------- 非法请求开始  -----------------------------------	
	ILLEAGE_HEADER_NULL("600001","头部加密参数有空值"),
	ILLEAGE_APPVERSION_NULL("600002","APP版本为空"),
	ILLEAGE_APPVERSION_ERROR("600003","APP版本非法"),
	ILLEAGE_SIGN_ERROR("600004","sign不匹配"),
	ILLEAGE_TIME_ERROR("600005","timestamp不匹配"),
	GETCODE_LOCK_NOW("600007","请求达到上限，请明天尝试"),
	GETCODE_LOCK_ONTDAY("600008","请求超过限制，锁定一天"),
	GETCODE_LOCK_THREEDAY("600009","请求超过限制，锁定三天"),
	GETCODE_LOCK_SEVENDAY("600010","请求超过限制，锁定七天"),

//----------------------------------- 内部异常提醒（用户不可见）-----------------------------------
	ILLEAGE_CLICK_REPEAT("700001","重复点击请求"),
	EXCEPTION("000002","系统异常"),
	;
	
	
	public String code;

	public String Desr;
    
    private CodeEnum(String code, String desr)
    {
        this.code = code;
        this.Desr = desr;
    }
    
    /**
     * 解析字符串.
     * 通过传入的 type 获取对应的中文
     * @return {@link UserSourceType}
     */
    public static final String parse(String inputCode)
    {
        if (StringUtils.isEmpty(inputCode))
        {
            return null;
        }
        try
        {
        	CodeEnum[] templateTypes = CodeEnum.values();
            
            for (CodeEnum codeEnum : templateTypes)
            {
                if (codeEnum.code.equals(inputCode))
                {
                    
                    return codeEnum.Desr;
                }
            }
            
            return String.valueOf(inputCode);
        }
        catch (Throwable t)
        {
            return String.valueOf(inputCode);
        }
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesr() {
		return Desr;
	}

	public void setDesr(String desr) {
		Desr = desr;
	}

}
