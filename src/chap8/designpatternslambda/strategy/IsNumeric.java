package chap8.designpatternslambda.strategy;

public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean validate(String str) {
        return str.matches("\\d+");
    }

}
