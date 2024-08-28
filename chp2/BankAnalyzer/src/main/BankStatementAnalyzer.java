package main;

import main.contracts.BankStatementParser;
import main.contracts.BankStatementReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    public void analyze(final String fileName, final BankStatementReader bankStatementReader, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(fileName);
        final List<String> lines = bankStatementReader.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in january is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in february is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("Min: " + bankStatementProcessor.getMin());
        System.out.println("Max: " + bankStatementProcessor.getMax());
    }
}
