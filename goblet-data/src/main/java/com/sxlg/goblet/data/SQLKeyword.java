package com.sxlg.goblet.data;

public enum SQLKeyword {

    INSERT_INTO("INSERT INTO "),
    DELETE("DELETE "),
    UPDATE("UPDATE "),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(") "),
    BLANK(" "),
    SET(" SET "),
    FROM(" FROM "),
    COMMA(","),
    VALUES("VALUES"),
    EQUAL("="),
    WHERE(" WHERE ");


    private String sqlKeyword;

    private SQLKeyword(String sqlKeyword) {
        this.sqlKeyword = sqlKeyword;
    }

    public String getSqlKeyword() {
        return sqlKeyword;
    }

}
