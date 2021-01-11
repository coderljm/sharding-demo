CREATE TABLE `student0` (
  `student_id` bigint(20) unsigned NOT NULL COMMENT '主键，雪花算法生成',
  `student_name` varchar(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `student_age` smallint(255) unsigned NOT NULL DEFAULT '0' COMMENT '学生年龄',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student1` (
  `student_id` bigint(20) unsigned NOT NULL COMMENT '主键，雪花算法生成',
  `student_name` varchar(50) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `student_age` smallint(255) unsigned NOT NULL DEFAULT '0' COMMENT '学生年龄',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;