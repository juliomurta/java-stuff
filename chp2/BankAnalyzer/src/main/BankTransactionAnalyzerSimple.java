package main;

import main.parsers.BankStatementCSVParser;
import main.parsers.BankStatementJsonParser;
import main.parsers.BankStatementXmlParser;
import main.readers.BankStatementCSVReader;
import main.readers.BankStatementJsonReader;
import main.readers.BankStatementXmlReader;

import java.io.IOException;

public class BankTransactionAnalyzerSimple {
    //private static final String RESOURCES = "target/classes/transactions.csv";
    //private static final String RESOURCES = "target/classes/transactions.json";
    private static final String RESOURCES = "target/classes/transactions.xml";

    public static void main(String[] args) throws Exception {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        //bankStatementAnalyzer.analyze(RESOURCES, new BankStatementCSVReader(), new BankStatementCSVParser());
        //bankStatementAnalyzer.analyze(RESOURCES, new BankStatementJsonReader(), new BankStatementJsonParser());
        bankStatementAnalyzer.analyze(RESOURCES, new BankStatementXmlReader(), new BankStatementXmlParser());
    }
}
