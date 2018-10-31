package com.dl.common.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dl.common.framework.redis.template.RedisConfigTemplate;
import com.dl.common.model.constant.Constant;
import com.dl.common.model.entity.system.SysConfig;
import com.dl.common.service.system.SysConfigService;

/**
 * 项目启动候执行方法体
 * @author levi.liu
 */
@Component
public class PreloadMethod implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	SysConfigService sysConfigService;
	@Autowired
	RedisConfigTemplate configTemplate;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//缓存接口请求参数校验
		ParamProps.loadDefinitions();
		ParamProps.print();
		//缓存消息模板
		MsgTemplateProps.loadDefinitions();
		MsgTemplateProps.print();
		//查询数据库，获取配置项list
		List<SysConfig> configList = sysConfigService.selectByStatus(Constant.STATUS_YES);
		//存储redis
		configTemplate.storeConfigList(null, configList);
	}

}
