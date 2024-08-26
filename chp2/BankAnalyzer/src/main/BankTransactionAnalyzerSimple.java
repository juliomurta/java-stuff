package main;

import java.io.IOException;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "out/production/BankAnalyzer/main/resources/transactions.csv";

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze(RESOURCES, new BankStatementCSVParser());
    }
}
