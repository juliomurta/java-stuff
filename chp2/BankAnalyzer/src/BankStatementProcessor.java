import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for(final BankTransaction bankTransaction: this.bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public List<BankTransaction> calculateTotalInMonth(final Month month) {
        final IEqualsCommand equalsCommand = new MonthEqualCommand(month);
        return this.calculateAmountByFilter(equalsCommand);
    }

    public List<BankTransaction> calculateTotalForCategory(final String category) {
        final IEqualsCommand equalsCommand = new StringEqualCommand(category);
        return this.calculateAmountByFilter(equalsCommand);
    }

    private List<BankTransaction> calculateAmountByFilter(IEqualsCommand equalsCommand) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final BankTransaction bankTransaction: this.bankTransactions){
            if (equalsCommand.isEqualsTo(bankTransaction)) {
                bankTransactions.add(bankTransaction);
            }
        }
        return bankTransactions;
    }
}
