package chap8.designpatternslambda.factory;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap;

public class FinancialToolFactory {

    private static final Map<String, Supplier<Financeable>> PRODUCT_MAP = ImmutableMap.of(
            "loan", Loan::new,
            "stock", Stock::new,
            "bond", Bond::new);

    private static final Map<String, Financeable> LAMBDA_MAP = ImmutableMap.of(
            "loan", () -> System.out.println("A loan"),
            "stock", () -> System.out.println("A stock"),
            "bond", () -> System.out.println("A bond"));

    public static Financeable makeProduct(String description) {
        return PRODUCT_MAP.get(description).get();
    }

    public static Financeable makeLambdaProduct(String description) {
        return LAMBDA_MAP.get(description);
    }

    public static void main(String[] args) {
        Financeable f = FinancialToolFactory.makeProduct("loan");
        Financeable f1 = FinancialToolFactory.makeLambdaProduct("loan");

        f.purchase();
        f1.purchase();
    }
}
