package sn.ndiaye.domain;

public abstract class SyntaxChecker {
    public static final String SYNTAX_ERROR = "SYNTAX ERROR";
    protected static final String SIMPLE_OPERATION= "\\-?\\d+[\\+\\-\\*\\/]\\d+";

    public abstract boolean check(String operation);
}
