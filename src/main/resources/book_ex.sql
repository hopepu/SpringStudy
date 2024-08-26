--프로젝트에 ojdbc8.jar 연결 한 후에 진행한다
--프로젝트 우클릭 -> buildpath -> configure buildpath -> Libraries 탭 -> Classpath에 ojdbc8.jar 삽입 -> apply
--Deployment Assemble -> java build path -> ojdbc8.jar 추가 -> apply
-- 결과 Referenced Libraries에 ojdbc6.jar가 보이면 성공 p80

create table tbl_board (
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

create sequence seq_board;

alter table tbl_board add constraint pk_board primary key (bno);

insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title1', 'test content1', 'user01');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title2', 'test content2', 'user02');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title3', 'test content3', 'user03');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title4', 'test content4', 'user04');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title5', 'test content5', 'user05');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title6', 'test content6', 'user06');
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test title7', 'test content7', 'user07');

create table tbl_reply(
	rno number(10,0),
	bno number(10,0) not null,
	reply varchar2(1000) not null,
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate	
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key(rno);

alter table tbl_reply add constraint fk_reply_board foreign key(bno) references tbl_board (bno);

select * from tbl_reply order by rno desc;

select * from tbl_board;

insert into tbl_reply (rno, bno, reply, replyer)
		values (seq_reply.nextval, '312', '리뷰 테스트', '테스터');

