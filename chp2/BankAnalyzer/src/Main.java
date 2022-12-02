import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String RESOURCES = "out/production/BankAnalyzer/main/resources/transactions.csv";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
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