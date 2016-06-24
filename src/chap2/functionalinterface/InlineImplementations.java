package chap2.functionalinterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InlineImplementations {

    private static Runnable lambdaRunnable =
            () -> System.out.println("Hello World 1");

    private static Runnable anonClassRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello World 2");
        }
    };

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(lambdaRunnable);
        exec.execute(anonClassRunnable);
        exec.execute(
                () -> System.out.println("Hello World 3"));
    }
}
