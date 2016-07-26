package chap8.designpatternslambda.templatemethod;

public class Restaurant {

    Chef chang = new ChineseChef();
    Chef manuel = new MexicanChef();

    public void getChinese() {
        chang.cook();
    }

    public void getMexican() {
        manuel.cook();
    }

    public static void main(String[] args) {
        Restaurant res = new Restaurant();
        res.getChinese();
        res.getMexican();
    }
}
