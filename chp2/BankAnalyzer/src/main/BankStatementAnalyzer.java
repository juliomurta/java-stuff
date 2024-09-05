package main;

import main.contracts.BankStatementParser;
import main.contracts.BankStatementReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private final BankStatementConfig statementConfig;

    public BankStatementAnalyzer(BankStatementConfig config) {
        statementConfig = config;
    }

    public String analyze(final String fileName) throws Exception {
        final BankStatementReader bankStatementReader = statementConfig.getReader();
        final BankStatementParser bankStatementParser = statementConfig.getParser();

        final Path path = Paths.get(fileName);
        final List<String> lines = bankStatementReader.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        return collectSummary(bankStatementProcessor);
    }

    private String collectSummary(final BankStatementProcessor bankStatementProcessor) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("Source type is ")
                .append(statementConfig.getSourceType())
                .append("\n")
                .append("The total for all transactions is ")
                .append(bankStatementProcessor.calculateTotalAmount())
                .append("\n")
                .append("The total for transactions in january is ")
                .append(bankStatementProcessor.calculateTotalInMonth(Month.JANUARY))
                .append("\n")
                .append("The total for transactions in february is ")
                .append(bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY))
                .append("\n")
                .append("The total salary received is ")
                .append(bankStatementProcessor.calculateTotalForCategory("Salary"))
                .append("\n")
                .append("Min: ")
                .append(bankStatementProcessor.getMin())
                .append("\n")
                .append("Max: ")
                .append(bankStatementProcessor.getMax());

        return stringBuilder.toString();
    }
}
