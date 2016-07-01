package chap3.constructorreference;

import java.util.function.Supplier;

public class PeachFarm {

    public static void main(String[] args) {
        Supplier<Peach> peachSupplier = Peach::new;
        Supplier<Peach> lambdaPeachSupplier = () -> new Peach();

        System.out.println(peachSupplier.get());
        System.out.println(peachSupplier.get());
        System.out.println(peachSupplier.get());
        System.out.println(peachSupplier.get());
    }
}
