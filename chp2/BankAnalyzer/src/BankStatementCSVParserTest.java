
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    private final BankStatementCSVParser bankParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction transaction = bankParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(transaction.getDate(), expected.getDate());
        Assert.assertEquals(transaction.getDescription(), expected.getDescription());
        Assert.assertEquals(transaction.getAmount(), expected.getAmount(), tolerance);
    }
}
