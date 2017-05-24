-- 数据库初始化脚本
-- 创建数据库
CREATE DATABASE stucourse;
-- 使用数据库
use stucourse;
drop database stucourse;

-- 院系表
CREATE TABLE tb_dept(
  dept_id CHAR(10) NOT NULL COMMENT '系号码',
  dept_name VARCHAR(40) NOT NULL COMMENT '系名称',
  dept_introduce TEXT NOT NULL COMMENT '系介绍',
  PRIMARY KEY (dept_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='院系表';

INSERT INTO tb_dept(dept_id, dept_name, dept_introduce)
VALUES ('0000000001','信息科学与技术学院','苟利国家生死以'),
       ('0000000002','理学院','理学院'),
       ('0000000003','机电学院','机电学院');

-- 创建专业表
CREATE TABLE tb_major(
  major_id CHAR(2) NOT NULL COMMENT '专业号',
  dept_id CHAR(10) NOT NULL COMMENT '系号码',
  major_name VARCHAR(40) NOT NULL COMMENT '专业名',
  major_introduce TEXT NOT NULL COMMENT '专业介绍',
  PRIMARY KEY (major_id),
  FOREIGN KEY (dept_id) REFERENCES tb_dept(dept_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业表';

INSERT INTO tb_major(major_id, dept_id, major_name, major_introduce)
VALUES ('01','0000000001','计算机科学与技术','计算机科学与技术'),
       ('02','0000000001','通信工程','通信工程'),
       ('03','0000000001','自动化','自动化'),
       ('04','0000000002','数学','数学'),
       ('05','0000000002','电科','电科'),
       ('06','0000000003','机械','机械');

-- 创建学生表
CREATE TABLE tb_stu(
  stu_id CHAR(10) NOT NULL COMMENT '学号',
  stu_name VARCHAR(40) NOT NULL COMMENT '姓名',
  stu_sex VARCHAR(6) NOT NULL COMMENT '性别',
  major_id CHAR(2) NOT NULL COMMENT '专业号码',
  stu_authority INT NOT NULL DEFAULT 0 COMMENT '默认选课权限',
  stu_password VARCHAR(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (stu_id),
  FOREIGN KEY (major_id) REFERENCES tb_major(major_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

INSERT INTO tb_stu(stu_id, stu_name, stu_sex, major_id, stu_password)
VALUES  ('2014123123', '李A', '男', '01','123456'),
        ('2014123124', '张B', '男', '02','123456'),
        ('2014123125', '王C', '女', '03','123456'),
        ('2014123126', '赵D', '男', '04','123456'),
        ('2014123127', '孙E', '女', '05','123456'),
        ('2014123128', '周F', '女', '06','123456'),
        ('2014123129', '吴G', '男', '01','123456'),
        ('2014121432', '郑H', '男', '02','123456'),
        ('2014121433', '钱I', '女', '03','123456'),
        ('2014121312', '冯J', '男', '04','123456');

-- 创建教师表
CREATE TABLE tb_teacher(
  teacher_id CHAR(10) NOT NULL COMMENT '教师工号',
  teacher_name VARCHAR(40) NOT NULL COMMENT '教师姓名',
  teacher_sex VARCHAR(6) NOT NULL COMMENT '性别',
  teacher_ranks VARCHAR(10) NOT NULL COMMENT '职称',
  teacher_authority INT NOT NULL DEFAULT 0 COMMENT '成绩提交权限',
  teacher_password VARCHAR(20) NOT NULL COMMENT '教师密码',
  dept_id CHAR(10) NOT NULL COMMENT '系号码',
  PRIMARY KEY (teacher_id),
  FOREIGN KEY (dept_id) REFERENCES tb_dept(dept_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

INSERT INTO tb_teacher(teacher_id, teacher_name, teacher_sex, teacher_ranks, dept_id)
VALUES  ('2014777123', '李AA', '男', '教授', '0000000001', '123456'),
        ('2014777124', '张BB', '男', '教授', '0000000001', '123456'),
        ('2014777125', '王CC', '女', '教授', '0000000001', '123456'),
        ('2014777126', '赵DD', '男', '教授', '0000000002', '123456'),
        ('2014777127', '孙EE', '女', '教授', '0000000002', '123456'),
        ('2014777128', '周FF', '女', '教授', '0000000002', '123456'),
        ('2014777129', '吴GG', '男', '教授', '0000000003', '123456'),
        ('2014777130', '郑HH', '男', '教授', '0000000003', '123456'),
        ('2014777131', '钱II', '女', '教授', '0000000003', '123456');

-- 创建课程表
CREATE TABLE tb_course(
  course_id CHAR(9) NOT NULL COMMENT '课程号',
  course_name VARCHAR(100) NOT NULL COMMENT '课程名',
  course_time INT NOT NULL COMMENT '学时',
  course_credit FLOAT NOT NULL COMMENT '学分',
  PRIMARY KEY (course_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

INSERT INTO tb_course(course_id, course_name, course_time, course_credit)
VALUES  ('CSE24306C', 'ACM/ICPC程序设计方法与实践', 2, 2.5),
        ('CSE31300C', '算法设计与分析', 2, 3.5),
        ('CSE32501C', '操作系统原理', 2, 3.5),
        ('EEE21501A', '数字逻辑', 2, 3.5),
        ('EEE33500A', '信号与系统', 2, 3.5),
        ('MAT21300T', '数论与组合数学', 2, 3.5),
        ('MAT25500T', '概率论与数理统计', 2, 3.5),
        ('MAT36200C', '计算方法', 2, 3.5),
        ('MXI22901E', '毛泽东思想和中国特色社会主义理论体系概论', 2, 3.5);

-- 创建授课表
CREATE TABLE tb_teach(
  teacher_id CHAR(10) NOT NULL COMMENT '教师工号',
  course_id CHAR(9) NOT NULL COMMENT '课程号',
  PRIMARY KEY (teacher_id, course_id),
  FOREIGN KEY (teacher_id) REFERENCES tb_teacher(teacher_id),
  FOREIGN KEY (course_id) REFERENCES tb_course(course_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授课表';

INSERT INTO tb_teach(teacher_id, course_id)
VALUES ('2014777123', 'CSE24306C'),
        ('2014777124', 'CSE31300C'),
        ('2014777129', 'CSE32501C'),
        ('2014777124', 'CSE32501C'),
        ('2014777126', 'EEE21501A'),
        ('2014777129', 'EEE33500A'),
        ('2014777131', 'MAT21300T'),
        ('2014777130', 'MAT25500T'),
        ('2014777125', 'MAT36200C'),
        ('2014777128', 'MXI22901E');

-- 创建选课信息表
CREATE TABLE tb_stucourse(
  stu_id CHAR(10) NOT NULL COMMENT '学号',
  course_id CHAR(9) NOT NULL COMMENT '课程号',
  teacher_id CHAR(10) NOT NULL COMMENT '教师工号',
  stucourse_grade FLOAT DEFAULT NULL COMMENT '课程成绩',
  PRIMARY KEY (stu_id, course_id, teacher_id),
  FOREIGN KEY (stu_id) REFERENCES tb_stu(stu_id),
  FOREIGN KEY (course_id) REFERENCES tb_course(course_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

INSERT INTO tb_stucourse(stu_id, course_id, teacher_id)
VALUES ('2014123123', 'CSE32501C', '2014777129'),
       ('2014123126', 'CSE31300C', '2014777124');

-- 创建管理员表
CREATE TABLE tb_manager(
  manager_id CHAR(10) NOT NULL COMMENT '管理员工号',
  manager_name VARCHAR(40) NOT NULL COMMENT '管理员姓名',
  manager_sex VARCHAR(6) NOT NULL COMMENT '管理员性别',
  manager_password VARCHAR(20) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (manager_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

INSERT INTO tb_manager(manager_id, manager_name, manager_sex, manager_password)
VALUE ('0000000000', 'admin', '男', '123456');