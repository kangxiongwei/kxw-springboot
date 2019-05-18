create table t_product (
  id bigint(20) not null primary key auto_increment,
  product_name varchar(64) not null comment '商品名称',
  stock int(11) not null default 0 comment '库存',
  price bigint(20) not null default 0 comment '单价，单位分',
  version int(11) not null default 0 comment '版本号',
  remark varchar(512) comment '备注',
  index idx_product_name(product_name)
) engine = InnoDB default charset = utf8mb4 comment '商品信息表';

create table t_purchase_record (
  id bigint(20) not null primary key auto_increment,
  user_id bigint(20) not null comment '用户编号',
  product_id bigint(20) not null comment '商品编号',
  price bigint(20) not null comment '单价',
  quantity int(11) not null default 0 comment '购买数量',
  total_price bigint(20) not null comment '总价',
  remark varchar(512) comment '备注',
  add_time datetime not null default now() comment '购买时间',
  index idx_user_id(user_id),
  index idx_product_id(product_id)
) engine = InnoDB default charset = utf8mb4 comment '购买信息表';