public class StringEqualCommand implements IEqualsCommand {

    private final String text;

    public StringEqualCommand(final String text) {
        this.text = text;
    }

    @Override
    public boolean isEqualsTo(final BankTransaction bankTransaction) {
        return bankTransaction.getDescription().equalsIgnoreCase(this.text);
    }
}
