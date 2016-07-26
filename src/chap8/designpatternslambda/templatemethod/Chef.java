package chap8.designpatternslambda.templatemethod;

public abstract class Chef {

    public void cook() {
        makeDrink();
        makeAppetizer();
        makeMeal();
        makeDessert();
    }

    private void makeDrink() {
        System.out.println("Martini to drink");
    }

    protected abstract void makeAppetizer();

    protected abstract void makeMeal();

    private void makeDessert() {
        System.out.println("Cake for desert");
    }

}
