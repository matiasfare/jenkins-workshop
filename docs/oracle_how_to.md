Para ejecutar procedure con cursor

SQL> start /vagrant/proc_users.sql;

SQL> var rc refcursor
SQL> execute get_users(:rc)

PL/SQL procedure successfully completed.

SQL> print rc