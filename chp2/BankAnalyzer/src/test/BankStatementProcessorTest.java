package test;

import main.BankStatementProcessor;
import main.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessorTest {
    final double tolerance = 0.0d;

    @Test
    public void calculateWithoutTransaction() {

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(null);
        Assert.assertEquals(0, bankStatementProcessor.calculateTotalAmount(), tolerance);

        bankStatementProcessor = new BankStatementProcessor(new ArrayList<BankTransaction>());
        Assert.assertEquals(0, bankStatementProcessor.calculateTotalAmount(), tolerance);
    }

    @Test
    public void calculateOneTransaction() {
        BankTransaction bankTransaction = new BankTransaction(LocalDate.of(2024, Month.APRIL, 11), 500, "test");
        List<BankTransaction> bankTransactions = new ArrayList<>();
        bankTransactions.add(bankTransaction);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        Assert.assertEquals(500, bankStatementProcessor.calculateTotalAmount(), tolerance);
    }

    @Test
    public void calculateTotalWithFiveTransactions() {
        List<BankTransaction> bankTransactions = this.setupFiveTransactions();
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        Assert.assertEquals(1500, bankStatementProcessor.calculateTotalAmount(), tolerance);
    }

    @Test
    public void calculateTotalInNonExistentMonth() {
        List<BankTransaction> bankTransactions = this.setupFiveTransactions();
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        Assert.assertEquals(0, bankStatementProcessor.calculateTotalInMonth(Month.AUGUST), tolerance);
    }

    @Test
    public void calculateTotalInMonth() {
        List<BankTransaction> bankTransactions = this.setupFiveTransactions();
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        Assert.assertEquals(300, bankStatementProcessor.calculateTotalInMonth(Month.APRIL), tolerance);
        Assert.assertEquals(900, bankStatementProcessor.calculateTotalInMonth(Month.JUNE), tolerance);
    }

    private List<BankTransaction> setupFiveTransactions() {
        BankTransaction transaction1 = new BankTransaction(LocalDate.of(2024, Month.APRIL, 11), 100, "test 1");
        BankTransaction transaction2 = new BankTransaction(LocalDate.of(2024, Month.APRIL, 29), 200, "test 2");
        BankTransaction transaction3 = new BankTransaction(LocalDate.of(2024, Month.MAY, 5), 300, "test 3");
        BankTransaction transaction4 = new BankTransaction(LocalDate.of(2024, Month.JUNE, 2), 400, "test 4");
        BankTransaction transaction5 = new BankTransaction(LocalDate.of(2024, Month.JUNE, 16), 500, "test 5");

        List<BankTransaction> bankTransactions = new ArrayList<>();
        bankTransactions.add(transaction1);
        bankTransactions.add(transaction2);
        bankTransactions.add(transaction3);
        bankTransactions.add(transaction4);
        bankTransactions.add(transaction5);

        return bankTransactions;
    }
}
