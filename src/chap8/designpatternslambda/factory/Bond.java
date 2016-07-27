package chap8.designpatternslambda.factory;

public class Bond implements Financeable {

    @Override
    public void purchase() {
        System.out.println("Purchased a bond");
    }

}
