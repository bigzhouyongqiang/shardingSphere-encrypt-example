create database shardingspheretest default character set utf8mb4 collate utf8mb4_unicode_ci;

use shardingspheretest;
create table t_order
(
  user_id varchar(1000),
  user_name varchar(1000)
);