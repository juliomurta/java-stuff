public class DefaultRule implements Rule {
    private final Condition condition;
    private final Action action;

    public DefaultRule(final Condition condition, final Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void perform(Facts facts) {
        if (this.condition.evaluate(facts)) {
            this.action.execute(facts);
        }
    }
}
