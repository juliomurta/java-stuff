package main;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        if (bankTransactions != null && !bankTransactions.isEmpty()) {
            for (final BankTransaction bankTransaction : bankTransactions) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return  total;
    }

    public BankTransaction getMin() {
        BankTransaction minTransaction = null;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if (minTransaction == null || bankTransaction.getAmount() < minTransaction.getAmount()) {
                minTransaction = bankTransaction;
            }
        }
        return minTransaction;
    }

    public BankTransaction getMax() {
        BankTransaction maxTransaction = null;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if (maxTransaction == null || bankTransaction.getAmount() > maxTransaction.getAmount()) {
                maxTransaction = bankTransaction;
            }
        }
        return maxTransaction;
    }
}
