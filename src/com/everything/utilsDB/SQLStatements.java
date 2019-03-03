package com.everything.utilsDB;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 28/08/14
 * Time: 11:34 AM
 */
public class SQLStatements {
    private Set<String> SAFE_STATEMENTS = new HashSet<>();
    {
        SAFE_STATEMENTS.add("SELECT");
    }

    private Set<String> UNSAFE_STATEMENTS_ONE_WORD = new HashSet<>();
    {
        UNSAFE_STATEMENTS_ONE_WORD.add("CREATE");
        UNSAFE_STATEMENTS_ONE_WORD.add("ALTER");
        UNSAFE_STATEMENTS_ONE_WORD.add("DROP");
        UNSAFE_STATEMENTS_ONE_WORD.add("TRUNCATE");
        UNSAFE_STATEMENTS_ONE_WORD.add("COMMENT");
        UNSAFE_STATEMENTS_ONE_WORD.add("RENAME");
        UNSAFE_STATEMENTS_ONE_WORD.add("INSERT");
        UNSAFE_STATEMENTS_ONE_WORD.add("UPDATE");
        UNSAFE_STATEMENTS_ONE_WORD.add("DELETE");
        UNSAFE_STATEMENTS_ONE_WORD.add("MERGE");
        UNSAFE_STATEMENTS_ONE_WORD.add("CALL");
        UNSAFE_STATEMENTS_ONE_WORD.add("GRANT");
        UNSAFE_STATEMENTS_ONE_WORD.add("REVOKE");
        UNSAFE_STATEMENTS_ONE_WORD.add("COMMIT");
        UNSAFE_STATEMENTS_ONE_WORD.add("SAVEPOINT");
        UNSAFE_STATEMENTS_ONE_WORD.add("ROLLBACK");
    }

    private Set<String> UNSAFE_STATEMENTS_SEVERAL_WORDS = new HashSet<>();
    {
        UNSAFE_STATEMENTS_SEVERAL_WORDS.add("EXPLAIN PLAN");
        UNSAFE_STATEMENTS_SEVERAL_WORDS.add("LOCK TABLE");
        UNSAFE_STATEMENTS_SEVERAL_WORDS.add("SET TRANSACTION");
    }

    public boolean isQuerySafe(String query) {
        boolean result = false;
        String upperCaseQuery = query.toUpperCase();

        List<String> queryWordList = Arrays.asList(upperCaseQuery.split("[^A-Z_]+"));
        Set<String> copyUnsafeStatementsOneWord = new HashSet<>(UNSAFE_STATEMENTS_ONE_WORD);
        copyUnsafeStatementsOneWord.retainAll(queryWordList);
        if(copyUnsafeStatementsOneWord.size()>0){
            result = false;
        } else{
            result = true;
        }

        for(String severalWordStatement : UNSAFE_STATEMENTS_SEVERAL_WORDS){
            if(upperCaseQuery.contains(severalWordStatement)){
                result = false;
                break;
            }
        }

//        System.out.println("intersection:");
//        for(String intersection : copyUnsafeStatementsOneWord){
//            System.out.println(intersection);
//        }
//        for(String unsafeStatement : UNSAFE_STATEMENTS_ONE_WORD){
//            for(String queryWord : queryWordList){
//                if(queryWord.equalsIgnoreCase(unsafeStatement)){
//                    System.out.println(queryWord);
//                }
//            }
//        }
        return result;
    }

}
