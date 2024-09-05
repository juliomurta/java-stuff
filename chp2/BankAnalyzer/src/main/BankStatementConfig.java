package main;

import main.contracts.BankStatementParser;
import main.contracts.BankStatementReader;
import main.parsers.BankStatementCSVParser;
import main.parsers.BankStatementJsonParser;
import main.parsers.BankStatementXmlParser;
import main.readers.BankStatementCSVReader;
import main.readers.BankStatementJsonReader;
import main.readers.BankStatementXmlReader;

import java.util.HashMap;
import java.util.Map;

public class BankStatementConfig {

    private final String sourceType;
    private final Map<String, BankStatementReader> readers = new HashMap<>();
    private final Map<String, BankStatementParser> parsers = new HashMap<>();


    public BankStatementConfig(String source){
        loadReaders();
        loadParsers();
        this.sourceType = source;
    }

    private void loadReaders() {
        this.readers.put("csv", new BankStatementCSVReader());
        this.readers.put("json", new BankStatementJsonReader());
        this.readers.put("xml", new BankStatementXmlReader());
    }

    private void loadParsers() {
        this.parsers.put("csv", new BankStatementCSVParser());
        this.parsers.put("json", new BankStatementJsonParser());
        this.parsers.put("xml", new BankStatementXmlParser());
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public BankStatementReader getReader() {
        return this.readers.get(this.getSourceType());
    }

    public BankStatementParser getParser() {
        return this.parsers.get(this.getSourceType());
    }
}
