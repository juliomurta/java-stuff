package main.parsers;

import main.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankStatementCSVParser extends BankStatementParserBase {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankTransaction parseFrom(final String line) throws Exception {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }
}
