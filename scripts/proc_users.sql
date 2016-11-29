
-- create procedure
create or replace procedure get_users (prc out sys_refcursor) is
begin
  open prc for select * from users;
end;
/
show errors;