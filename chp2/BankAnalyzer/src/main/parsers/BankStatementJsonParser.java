package main.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.contracts.BankStatementParser;
import main.BankTransaction;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementJsonParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BankTransaction parseFrom(final String line) throws Exception {
        final JsonNode element = objectMapper.readTree(line);

        final LocalDate localDate = LocalDate.parse(element.get("date").asText(), DATE_PATTERN);
        final double amount = element.get("amount").asDouble(0d);
        final String description = element.get("description").asText("");

        return new BankTransaction(localDate, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(final List<String> lines) throws Exception {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines) {
            final BankTransaction transaction = this.parseFrom(line);
            bankTransactions.add(transaction);
        }
        return bankTransactions;
    }
}
