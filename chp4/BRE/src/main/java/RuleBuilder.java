public class RuleBuilder {
    private Condition condition;

    private RuleBuilder(final Condition condition) {
        this.condition = condition;
    }

    public static RuleBuilder when(Condition condition) {
        return new RuleBuilder(condition);
    }

    public Rule createRule(final Action action) {
        return new DefaultRule(this.condition, action);
    }
}
