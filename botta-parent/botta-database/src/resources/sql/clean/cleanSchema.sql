-- ----------------------------------------------------------------------------
-- Cleaning the schema
-- ----------------------------------------------------------------------------
--
-- what we actually want to do:
--
--	Drop all tables from the tablespace botta.
--
BEGIN
	FOR i IN (SELECT t.table_name FROM all_tables t WHERE t.owner = UPPER('botta')) LOOP
		EXECUTE IMMEDIATE('DROP TABLE '||UPPER('botta')||'.'||i.table_name||' CASCADE CONSTRAINTS');
	END LOOP;
END; 
/