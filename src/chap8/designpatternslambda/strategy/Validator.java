package chap8.designpatternslambda.strategy;

import lombok.Setter;

public class Validator {

    @Setter
    private ValidationStrategy validation;

    public Validator(ValidationStrategy validation) {
        super();
        this.validation = validation;
    }

    public boolean validate(String s) {
        return validation.validate(s);
    }


    static void testStrategy() {
        ValidationStrategy lowerCase = new IsAllLowerCase();
        ValidationStrategy numeric = new IsNumeric();

        Validator v = new Validator(lowerCase);
        String test1 = "i am all lowercase";
        String test2 = "12345";

        System.out.println(v.validate(test1));
        System.out.println(v.validate(test2));
        v.setValidation(numeric);
        System.out.println(v.validate(test1));
        System.out.println(v.validate(test2));
    }

    static void testLambdaStrategy() {
        final String lowerCaseRegEx = "[a-z]+";
        final String numericRegEx = "\\d+";

        ValidationStrategy lowerCase = s -> s.matches(lowerCaseRegEx);
        ValidationStrategy numeric = s -> s.matches(numericRegEx);

        Validator v = new Validator(lowerCase);
        String test1 = "i am all lowercase";
        String test2 = "12345";

        System.out.println(v.validate(test1));
        System.out.println(v.validate(test2));
        v.setValidation(numeric);
        System.out.println(v.validate(test1));
        System.out.println(v.validate(test2));
    }
    public static void main(String[] args) {
        testStrategy();
        testLambdaStrategy();
    }

}
