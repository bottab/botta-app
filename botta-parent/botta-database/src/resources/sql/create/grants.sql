-- ----------------------------------------------------------------------------
-- Create the schema
-- ----------------------------------------------------------------------------

-- Create the new schema/user
create user botta identified by botta default tablespace botta_tablespace;
grant connect, resource to botta;
alter user botta quota unlimited on botta_tablespace;
grant create table to botta;
commit;