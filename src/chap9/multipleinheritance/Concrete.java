package chap9.multipleinheritance;

public class Concrete implements InterfaceA, InterfaceB{

    @Override
    public int check() {
        return InterfaceB.super.check();
    }

}
