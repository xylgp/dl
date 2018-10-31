






















CREATE TABLE `tbl_user_acount` (
  `userId` varchar(40) NOT NULL COMMENT '�û�id',
  `version` int(11) DEFAULT NULL COMMENT '�汾',
  `incomeTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '������',
  `balanceTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '�����',
  `forzenAmountTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '������',
  `availableAmountTotal` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '�������',
  `payPwd` varchar(256) DEFAULT NULL COMMENT '֧������',
  `zfbAccount` varchar(50) DEFAULT NULL COMMENT '֧�����˺�',
  `zfbName` varchar(30) DEFAULT NULL COMMENT '֧��������',
  `openid` varchar(40) DEFAULT NULL COMMENT '΢���û�Ψһ��ʶ',
  `wxName` varchar(20) DEFAULT NULL COMMENT '΢���˻�',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û��˻���';

CREATE TABLE `tbl_user_operator` (
  `ID` varchar(40) NOT NULL COMMENT 'ID',
  `VERSION` varchar(20) NOT NULL DEFAULT '0' COMMENT 'VERSION',
  `CREATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `LOGINNAME` varchar(50) NOT NULL COMMENT '��¼��',
  `LOGINPWD` varchar(256) DEFAULT NULL COMMENT '��¼����',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '����',
  `MOBILENO` varchar(15) NOT NULL COMMENT '�ֻ���',
  `STATUS` varchar(10) NOT NULL DEFAULT '0' COMMENT '�û�״̬��0�����ã�1��ͣ�ã�',
  `LASTLOGINTIME` datetime DEFAULT NULL COMMENT '����¼ʱ��',
  `ISCHANGEDPWD` smallint(6) NOT NULL DEFAULT '0' COMMENT '�Ƿ���Ĺ�����(1:�Ѹ��ģ�0:δ����)',
  `PWDERRORCOUNT` smallint(6) DEFAULT '0' COMMENT '��������������������5�����Ͷ����ʺţ�',
  `ISEMAILCHECK` smallint(6) DEFAULT NULL COMMENT '�Ƿ�������֤ 0��δ��֤��1������֤',
  `ISPHONECHECK` smallint(6) DEFAULT NULL COMMENT '�Ƿ��ֻ���֤ 0��δ��֤��1������֤',
  `PWDERRORTIME` datetime DEFAULT NULL COMMENT '����������ʱ��',
  `TOKEN` varchar(200) DEFAULT NULL,
  UNIQUE KEY `A_KEY_2` (`LOGINNAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';


















