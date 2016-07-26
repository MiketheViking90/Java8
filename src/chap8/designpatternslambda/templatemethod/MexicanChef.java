package chap8.designpatternslambda.templatemethod;

public class MexicanChef extends Chef {

    @Override
    protected void makeAppetizer() {
        System.out.println("Tacos for appetizer");
    }

    @Override
    protected void makeMeal() {
        System.out.println("Burrito for dinner");
    }

}
