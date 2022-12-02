import java.time.Month;

public class MonthEqualCommand implements  IEqualsCommand {

    private final Month month;

    public MonthEqualCommand(final Month month) {
        this.month = month;
    }

    @Override
    public boolean isEqualsTo(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == month;
    }
}
