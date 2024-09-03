package test;

import main.BankTransaction;
import main.contracts.BankStatementParser;
import main.parsers.BankStatementJsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementJsonParserTest {
    private final BankStatementParser statementParser = new BankStatementJsonParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "{\n" +
                "    \"date\": \"30-01-2017\",\n" +
                "    \"amount\": -100,\n" +
                "    \"description\": \"Deliveroo\"\n" +
                "  }";
        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
