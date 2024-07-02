# 1. 회원 테이블
create table member(	# 회원코드, 아이디, 비번, 회원이름, 운동습관, 성별, 생년월일, 연락처, 회원분류코드
	memberCode int auto_increment,
    ID varchar(20) not null unique,
    PW varchar(20) not null,
    memberName varchar(20) not null,
    height SMALLINT not null,
    exHabit TINYINT not null,
    gender CHAR(1) not null,
    birthDate varchar(20),
	contact varchar(20) not null,
    accCategory TINYINT not null,
    primary key(memberCode)
);


# 2. 운동 기록 테이블
create table workoutrecord(
	workOutCode int auto_increment,
    workOutTime DATETIME,
    exCode int,
    membercode int,
    primary key(workOutCode),
	foreign key(exCode) references member(exCode),
    foreign key(membercode) references member(membercode)
);

# 3. 먹은 음식 기록 테이블
create table atefoodrecord(
	ateFoodCode int auto_increment,
    foodCode int,
    ateTime datetime,
    membercode int,
    primary key(ateFoodCode),
    foreign key(foodCode) references member(foodCode),
	foreign key(membercode) references member(membercode)
);

# 4. 음식 테이블
create table food




