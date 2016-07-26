package chap8.designpatternslambda.templatemethod;

public class ChineseChef extends  Chef {

    @Override
    protected void makeAppetizer() {
        System.out.println("Egg roll for appetizer");
    }

    @Override
    protected void makeMeal() {
        System.out.println("Stir fry bell peppers with beef");
    }

}
