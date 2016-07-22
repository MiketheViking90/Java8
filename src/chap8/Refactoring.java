package chap8;

public class Refactoring {

    void anonRunnable() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
    }

    void lambdaRunnable() {
        Runnable r = () -> System.out.println("hello");
    }

    void shadowVarAnon() {
        int val = 10;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                int val = 2;
                System.out.println(val);
            }
        };
    }

    void shadowVarLambda() {
        Runnable r = () -> {
            int val = 2;
            System.out.println(val);
        };
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}