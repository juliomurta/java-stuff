public class JobTitleCondition implements ConditionalAction{
    @Override
    public boolean evaluate(Facts facts) {
        return "CEO".equals(facts.getFact("jobTitle"));
    }

    @Override
    public void perform(Facts facts) {
        throw new UnsupportedOperationException();
    }
}
