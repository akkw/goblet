DROP database if exists goblet_source;
create database goblet_source;
use goblet_source;
create table goblet(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

DROP database if exists goblet_sink;

create database goblet_sink;

use goblet_sink;

create table goblet_0(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8)  comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_1(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_2(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_3(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_4(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_5(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_6(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_7(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));


create table goblet_8(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_9(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32)  comment '销售总量',
primary key(id));

create table goblet_10(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross  int(32) comment '商品总量',
total_sales_volume  int(32) comment '销售总量',
primary key(id));

create table goblet_11(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_12(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross  int(32) comment '商品总量',
total_sales_volume   int(32) comment '销售总量',
primary key(id));

create table goblet_13(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross  int(32) comment '商品总量',
total_sales_volume  int(32) comment '销售总量',
primary key(id));

create table goblet_14(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_15(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_16(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_17(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_18(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_19(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_20(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));


create table goblet_21(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_22(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_23(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));


create table goblet_24(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_25(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_26(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_27(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_28(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_29(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_30(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));

create table goblet_31(
id int comment '商品id',
name varchar(32) comment '商品名字',
price double comment '商品价格',
serial_number varchar(64) comment '商品编号',
quantity_in_stock int(8) comment '库存数量',
merchandise_wantage int(8) comment '缺货数量',
buy_limit int(8) comment '购买上限',
lower_limit int(8) comment '购买下限',
merchandise_gross int(32) comment '商品总量',
total_sales_volume int(32) comment '销售总量',
primary key(id));
