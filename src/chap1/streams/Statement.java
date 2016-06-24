package chap1.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statement {

    private List<Transaction> transactions;

    public Map<Currency, List<Transaction>> mapCurrenciesToTransactions() {
        Map<Currency, List<Transaction>> currencyToTransactionsMap = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getPrice() > 100) {
                List<Transaction> transactionsForCurrency =
                        currencyToTransactionsMap.get(t.getCurrency());
                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    currencyToTransactionsMap.put(t.getCurrency(), transactionsForCurrency);
                }
                transactionsForCurrency.add(t);
            }
        }
        return currencyToTransactionsMap;
    }

}
