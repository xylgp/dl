-- 用户表
CREATE TABLE `tbl_user` (
  `ID` varchar(40) NOT NULL COMMENT 'ID',
  `VERSION` varchar(20) NOT NULL DEFAULT '0' COMMENT 'VERSION',
  `CREATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `LOGINNAME` varchar(50) NOT NULL COMMENT '登录名',
  `LOGINPWD` varchar(256) DEFAULT NULL COMMENT '登录密码',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `MOBILENO` varchar(15) NOT NULL COMMENT '手机号',
  `STATUS` varchar(10) NOT NULL DEFAULT '0' COMMENT '用户状态（0：启用，1：停用）',
  `LASTLOGINTIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `ISCHANGEDPWD` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否更改过密码(1:已更改，0:未更改)',
  `PWDERRORCOUNT` smallint(6) DEFAULT '0' COMMENT '连续输错密码次数（连续5次输错就冻结帐号）',
  `ISEMAILCHECK` smallint(6) DEFAULT NULL COMMENT '是否邮箱验证 0、未验证，1、已验证',
  `ISPHONECHECK` smallint(6) DEFAULT NULL COMMENT '是否手机验证 0、未验证，1、已验证',
  `PWDERRORTIME` datetime DEFAULT NULL COMMENT '最后输错密码时间',
  `TOKEN` varchar(200) DEFAULT NULL,
  UNIQUE KEY `A_KEY_2` (`LOGINNAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 角色表
CREATE TABLE `tbl_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(20) NOT NULL COMMENT '角色代码',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关联表';

CREATE TABLE `tbl_menu_child` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '模块名',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `sort_no` int(11) NOT NULL COMMENT '排序',
  `status` int(11) NOT NULL COMMENT '状态',
  `url` varchar(200) NOT NULL COMMENT '模块url',
  `module_group_id` int(11) DEFAULT NULL COMMENT '所属组ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='子菜单表';

CREATE TABLE `tbl_menu_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '模块组名',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `sort_no` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单组表';

CREATE TABLE `tbl_menu_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `module_id` int(11) NOT NULL COMMENT '模块id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单权限表';

CREATE TABLE `tbl_role_auth` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `auth_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限表';