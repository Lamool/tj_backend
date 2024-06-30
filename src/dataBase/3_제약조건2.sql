drop database if exists category;
drop database if exists menu;
drop database if exists orderList;
drop database if exists orderInfo;

# 카테고리
create table category(
	categoryCode_pk int auto_increment,
	categoryName varchar(20) not null unique,
    primary key(categoryCode_pk)
);

# 메뉴
create table menu(
	menuCode_pk int auto_increment,
	menuPrice int not null,
	menuName varchar(50) not null unique,
    categoryCode_fk int,
    primary key(menuCode_pk),
    foreign key(categoryCode_fk) references category(categoryCode_pk)
);

# 주문
create table orderList(
	orderCode_pk int auto_increment,
	orderDate datetime default now(),
    primary key(orderCode_pk)
);

# 주문상세
create table orderInfo(
	orderInfoCode_pk int auto_increment,
	orderAmount int not null,
    menuCode_fk int,
    orderCode_fk int,
    primary key(orderInfoCode_pk),
    foreign key(menuCode_fk) references menu(menuCode_pk),
    foreign key(orderCode_fk) references orderList(orderCode_pk)
);

# 확인
select * from category;
select * from menu;
select * from orderList;
select * from orderInfo;
