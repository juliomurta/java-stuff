package main.parsers;

import main.BankTransaction;
import main.contracts.BankStatementParser;

import java.util.ArrayList;
import java.util.List;

public abstract class BankStatementParserBase implements BankStatementParser {

    public abstract BankTransaction parseFrom(final String line) throws Exception;

    public List<BankTransaction> parseLinesFrom(final List<String> lines) throws Exception {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line: lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
