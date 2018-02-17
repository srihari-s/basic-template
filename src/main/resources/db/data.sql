--insert into auth(username,passkey) values('dev1', 'devzone123');
--insert into auth(username,passkey) values('test', 'crazyone');

insert into auth(username,passkey) select * from (
select 'dev1', 'devzone123' union
select 'test', 'crazyone' ) x where not exists(select * from auth);