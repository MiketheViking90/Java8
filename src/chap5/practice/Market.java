package chap5.practice;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Market {
    Trader raoul = new Trader("Raoul", "Cambridge"),
           mario = new Trader("Mario", "Milan"),
           alan = new Trader("Alan", "Cambridge"),
           brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    private void findSort2011Transactions() {
        System.out.println("Find all transactions in the year 2011 and sort by value?");
        transactions.stream()
                    .filter(t -> (t.getYear() == 2011))
                    .sorted(comparing(Transaction::getValue))
                    .map(t -> t.getYear() + ", " + t.getValue())
                    .forEach(System.out::println);;
        System.out.println();
    }

    private void findUniqueCities() {
        System.out.println("What are all the unique cities where traders work?");
        transactions.stream()
                    .map(Transaction::getTrader)
                    .map(Trader::getCity)
                    .distinct()
                    .forEach(System.out::println);;
        System.out.println();
    }

    private void findAndSortCambridgeTraders() {
        System.out.println("Find all traders from Cambridge and sort by name.");
        transactions.stream()
                    .map(Transaction::getTrader)
                    .distinct()
                    .filter(t -> t.getCity().equals("Cambridge"))
                    .sorted(comparing(Trader::getName))
                    .forEach(System.out::println);;
        System.out.println();
    }

    private void sortNames() {
        System.out.println("Return a string of all trader's names sorted.");
        String names = transactions.stream()
                                   .map(Transaction::getTrader)
                                   .map(Trader::getName)
                                   .distinct()
                                   .sorted()
                                   .reduce((a, b) -> a + ", " + b)
                                   .get();
        System.out.println(names);
        System.out.println();
    }

    private void findMilan() {
        System.out.println("Are there any traders based in Milan?");
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(t -> t.getCity().equals("Milan"))
                    .forEach(System.out::println);
        System.out.println();
    }

    private void findTransactionValuesFromTradersInCambridge() {
        System.out.println("Print all transctions' values form the traders living in Cambridge.");
        Predicate<Transaction> transactionsInCambridgeFilter =
                (Transaction t) -> t.getTrader().getCity().equals("Cambridge");
        transactions.stream()
                    .filter(transactionsInCambridgeFilter)
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
        System.out.println();
    }

    private void findHighestValue() {
        System.out.println("What's the highest value of all the transcitons?");
        int max = transactions.stream()
                              .map(Transaction::getValue)
                              .reduce(Integer::max).get();
        System.out.println(max);
        System.out.println();
    }

    private void findLowestValue() {
        System.out.println("Find the transaction with the smallest value.");
        int min = transactions.stream()
                             .map(Transaction::getValue)
                             .reduce(Integer::min).get();
        System.out.println(min);
        System.out.println();
    }
    public static void main(String[] args) {
        Market market = new Market();
        market.findSort2011Transactions();
        market.findUniqueCities();
        market.findAndSortCambridgeTraders();
        market.sortNames();
        market.findMilan();
        market.findTransactionValuesFromTradersInCambridge();
        market.findHighestValue();
        market.findLowestValue();
    }
}
