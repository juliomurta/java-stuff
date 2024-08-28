package main.parsers;

import main.contracts.BankStatementParser;
import main.BankTransaction;

import java.util.List;

public class BankStatementXmlParser implements BankStatementParser {
    @Override
    public BankTransaction parseFrom(String line) {
        return null;
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return List.of();
    }
}
