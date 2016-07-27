package chap8.designpatternslambda.factory;

public class Loan implements Financeable {

    @Override
    public void purchase() {
        System.out.println("Purchase a loan");
    }

}
