package main;

import main.contracts.BankStatementParser;
import main.contracts.BankStatementReader;

public class BankStatementConfig {

    private BankStatementReader statementReader;
    private BankStatementParser statementParser;

    public void setReader(BankStatementReader reader) {
        statementReader = reader;
    }

    public void setParser(BankStatementParser parser) {
        statementParser = parser;
    }

    public BankStatementReader getReader() {
        return statementReader;
    }

    public BankStatementParser getParser() {
        return statementParser;
    }
}
