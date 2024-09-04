package main;

import main.parsers.BankStatementCSVParser;
import main.parsers.BankStatementJsonParser;
import main.parsers.BankStatementXmlParser;
import main.readers.BankStatementCSVReader;
import main.readers.BankStatementJsonReader;
import main.readers.BankStatementXmlReader;
import main.ui.MainForm;


public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "target/classes/transactions.csv";
    //private static final String RESOURCES = "target/classes/transactions.json";
    //private static final String RESOURCES = "target/classes/transactions.xml";

    public static void main(String[] args) throws Exception {
        /*final BankStatementConfig statementConfig = new BankStatementConfig();
        statementConfig.setReader(new BankStatementCSVReader());
        statementConfig.setParser(new BankStatementCSVParser());

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(statementConfig);
        bankStatementAnalyzer.analyze(RESOURCES);*/

        MainForm mainForm = new MainForm();
    }
}
