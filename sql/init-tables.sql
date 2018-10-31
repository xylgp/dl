






















CREATE TABLE `tbl_user_acount` (
  `userId` varchar(40) NOT NULL COMMENT '用户id',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `incomeTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '总收益',
  `balanceTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '总余额',
  `forzenAmountTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '冻结金额',
  `availableAmountTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '可用余额',
  `payPwd` varchar(256) DEFAULT NULL COMMENT '支付密码',
  `zfbAccount` varchar(50) DEFAULT NULL COMMENT '支付宝账号',
  `zfbName` varchar(30) DEFAULT NULL COMMENT '支付宝姓名',
  `openid` varchar(40) DEFAULT NULL COMMENT '微信用户唯一标识',
  `wxName` varchar(20) DEFAULT NULL COMMENT '微信账户',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户表';

CREATE TABLE `tbl_user_operator` (
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


















