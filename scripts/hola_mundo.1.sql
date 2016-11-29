-- just for demonstration with dbms_output
set serveroutput on

-- create procedure
create or replace procedure foo is
begin
  dbms_output.put_line('Hola Mundo SQL Stored Procedure!');
end;
/
show errors

-- execute procedure
exec foo

-- remove procedure
drop procedure foo;

-- exit sqlplus
exit
