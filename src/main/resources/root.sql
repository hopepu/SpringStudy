create user book_ex identified by book_ex default tablespace users temporary tablespace temp;
drop user book_ex;

grant connect, dba to book_ex;

select dbms_xdb.gethttpport() from dual;  --8080 포트 사용 중임을 확인

exec dbms_xdb.sethttpport(9090); -- 이클립스에서는 지원 되지 않는 명령어