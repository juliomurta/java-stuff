package main.parsers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankStatementJsonParser extends BankStatementParserBase {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected ObjectMapper objectMapper = new ObjectMapper();

    public BankTransaction parseFrom(final String line) throws Exception {
        final JsonNode element = objectMapper.readTree(line);

        final LocalDate localDate = LocalDate.parse(element.get("date").asText(), DATE_PATTERN);
        final double amount = element.get("amount").asDouble(0d);
        final String description = element.get("description").asText("");

        return new BankTransaction(localDate, amount, description);
    }
}
