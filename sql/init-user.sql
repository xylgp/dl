-- �û���
CREATE TABLE `tbl_user` (
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

-- ��ɫ��
CREATE TABLE `tbl_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `code` varchar(20) NOT NULL COMMENT '��ɫ����',
  `name` varchar(50) NOT NULL COMMENT '��ɫ��',
  `remark` varchar(200) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='��ɫ��';

CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL COMMENT '�û�id',
  `role_id` int(11) NOT NULL COMMENT '��ɫid',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='�û���ɫ������';

CREATE TABLE `tbl_menu_child` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(20) NOT NULL COMMENT 'ģ����',
  `remark` varchar(200) DEFAULT NULL COMMENT '��ע',
  `sort_no` int(11) NOT NULL COMMENT '����',
  `status` int(11) NOT NULL COMMENT '״̬',
  `url` varchar(200) NOT NULL COMMENT 'ģ��url',
  `module_group_id` int(11) DEFAULT NULL COMMENT '������ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='�Ӳ˵���';

CREATE TABLE `tbl_menu_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(20) NOT NULL COMMENT 'ģ������',
  `remark` varchar(200) DEFAULT NULL COMMENT '��ע',
  `sort_no` int(11) NOT NULL COMMENT '����',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='�˵����';

CREATE TABLE `tbl_menu_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `code` varchar(50) NOT NULL COMMENT '����',
  `name` varchar(20) NOT NULL COMMENT '����',
  `module_id` int(11) NOT NULL COMMENT 'ģ��id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='�˵�Ȩ�ޱ�';

CREATE TABLE `tbl_role_auth` (
  `role_id` int(11) NOT NULL COMMENT '��ɫid',
  `auth_id` int(11) NOT NULL COMMENT 'Ȩ��id',
  PRIMARY KEY (`role_id`,`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='��ɫȨ�ޱ�';