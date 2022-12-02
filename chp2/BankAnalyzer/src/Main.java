import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class Main {
    private static final String RESOURCES = "out/production/BankAnalyzer/main/resources/transactions.csv";

    public static void main(String[] args) throws IOException {

        final IBankStatementParser bankStatementParser = new BankStatementCSVParser();
        BankStatementAnalyzer bankAnalyzer = new BankStatementAnalyzer();
        bankAnalyzer.analyze(RESOURCES, bankStatementParser);
    }
}