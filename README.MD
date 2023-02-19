### 打包指令
```
# 开发环境
mvn clean compile package -U -Pdev -skipTest=true
# 测试环境
mvn clean compile package -U -Psit -skipTest=true
# 预生产环境
mvn clean compile package -U -Puat -skipTest=true
# 生产环境
mvn clean compile package -U -Pprod -skipTest=true
```

### 初始化脚本
```mysql
create table t_user
(
    id       bigint auto_increment
        primary key,
    username varchar(50) null
);

INSERT INTO t_user (id, username) VALUES (1, 'a');
INSERT INTO t_user (id, username) VALUES (2, 'b');
INSERT INTO t_user (id, username) VALUES (3, 'c');
INSERT INTO t_user (id, username) VALUES (4, 'd');
INSERT INTO t_user (id, username) VALUES (5, 'e');
INSERT INTO t_user (id, username) VALUES (6, 'f');
INSERT INTO t_user (id, username) VALUES (7, 'g');
INSERT INTO t_user (id, username) VALUES (8, 'h');
INSERT INTO t_user (id, username) VALUES (9, 'i');
INSERT INTO t_user (id, username) VALUES (10, 'j');
INSERT INTO t_user (id, username) VALUES (11, 'k');
INSERT INTO t_user (id, username) VALUES (12, 'l');
INSERT INTO t_user (id, username) VALUES (13, 'm');
INSERT INTO t_user (id, username) VALUES (14, 'n');
INSERT INTO t_user (id, username) VALUES (15, 'o');
INSERT INTO t_user (id, username) VALUES (16, 'p');
INSERT INTO t_user (id, username) VALUES (17, 'q');
INSERT INTO t_user (id, username) VALUES (18, 's');

```