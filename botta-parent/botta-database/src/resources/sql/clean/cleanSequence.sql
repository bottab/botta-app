BEGIN
   FOR cc IN (SELECT sequence_name as sequence_exists
                FROM all_sequences
               WHERE sequence_owner = UPPER('botta')
                 AND sequence_name = UPPER('botta_sequence')) LOOP
      -- sequence exists, drop it (at most there will be *one* sequence)
      Execute IMMEDIATE('DROP Sequence '||UPPER('botta')||'.'||UPPER('botta_sequence'));
   END LOOP;
END;
/