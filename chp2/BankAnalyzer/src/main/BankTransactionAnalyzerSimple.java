package main;

import main.parsers.BankStatementCSVParser;
import main.parsers.BankStatementJsonParser;
import main.readers.BankStatementCSVReader;

import java.io.IOException;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "out/production/BankAnalyzer/main/resources/transactions.csv";
    //private static final String RESOURCES = "out/production/BankAnalyzer/main/resources/transactions.json";

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze(RESOURCES, new BankStatementCSVReader(), new BankStatementCSVParser());
        //bankStatementAnalyzer.analyze(RESOURCES, new BankStatementJsonParser());
    }
}
