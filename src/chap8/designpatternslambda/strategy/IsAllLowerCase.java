package chap8.designpatternslambda.strategy;

public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean validate(String str) {
        return str.matches("[a-z]+");
    }

}
