import java.util.List;

public class Report {
    final Facts facts;
    final ConditionalAction conditionalAction;
    final boolean isPositive;

    public Report(final Facts facts, final ConditionalAction conditionalAction, final boolean isPositive) {
        this.facts = facts;
        this.conditionalAction = conditionalAction;
        this.isPositive = isPositive;
    }

    public Facts getFacts() {
        return this.facts;
    }

    public ConditionalAction getConditionalAction() {
        return this.conditionalAction;
    }

    public boolean getIsPositive() {
        return this.isPositive;
    }

    public String toString() {
        return "Report{" +
                "conditionalAction" + conditionalAction +
                "facts=" + facts +
                "isPositive=" + isPositive +
                "}";
    }
}
