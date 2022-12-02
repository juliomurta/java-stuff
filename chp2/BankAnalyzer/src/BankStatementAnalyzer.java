import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    public void analyze(final String filePath, IBankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(filePath);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        displaySummary(bankStatementProcessor);
    }

    public static void displaySummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("O total para todas as transacoes eh: " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transacoes de janeiro: " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transacoes de fevereiro: " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("Transacoes categoria Salary: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
