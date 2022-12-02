import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + this.date +
                ", amount=" + this.amount +
                ", description='" + this.description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
