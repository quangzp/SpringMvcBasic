use springmvc;

insert into role(code,roleName) values('ADMIN','Quản trị');
insert into role(code,roleName) values('USER','Người dùng');

insert into user(username,password,fullName,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trương tùng lâm',1);
insert into user(username,password,fullName,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn A',1);
insert into user(username,password,fullName,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn B',1);

INSERT INTO user_role(userId,roleId) VALUES (1,1);
INSERT INTO user_role(userId,roleId) VALUES (2,2);
INSERT INTO user_role(userId,roleId) VALUES (3,2);