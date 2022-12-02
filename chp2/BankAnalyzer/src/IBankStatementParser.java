import java.util.List;

public interface IBankStatementParser {
    BankTransaction parseFrom(final String line);

    List<BankTransaction> parseLinesFrom(final List<String> lines);
}
