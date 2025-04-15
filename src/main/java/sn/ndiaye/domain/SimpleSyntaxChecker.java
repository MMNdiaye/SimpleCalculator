package sn.ndiaye.domain;

public class SimpleSyntaxChecker extends SyntaxChecker{

    @Override
    public boolean check(String operation) {
        return operation.matches(SIMPLE_OPERATION);
    }
}
