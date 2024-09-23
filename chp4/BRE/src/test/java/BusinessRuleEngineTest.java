import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BusinessRuleEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
        var businessRuleEngine = new BusinessRuleEngine(mock(Facts.class));
        Assert.assertEquals(0, businessRuleEngine.count());
    }

    @Test
    public void shouldHaveTwoRules() {
        var businessRuleEngine = new BusinessRuleEngine(mock(Facts.class));
        businessRuleEngine.addAction((Facts facts) -> { });
        businessRuleEngine.addAction((Facts facts) -> { });
        Assert.assertEquals(2, businessRuleEngine.count());
    }

    @Test
    public void shouldRunAnonimousTask() {
        var facts = new Facts();
        facts.addFact("name", "Nate Higgers");
        facts.addFact("jobTitle", "CEO");

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
        businessRuleEngine.addAction(new Action() {
            @Override
            public void execute(Facts facts1) {
                var jobTitle = facts1.getFact("jobTitle");
                if ("CEO".equals(jobTitle)) {
                  System.out.println("sent email");
                }
            }
        });

        businessRuleEngine.run();
    }

    @Test
    public void shouldPerformAnActionWithFacts() {
        var mockAction = mock(Action.class);
        var mockFacts = mock(Facts.class);
        var businessRuleEngine = new BusinessRuleEngine(mockFacts);
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();
        verify(mockAction).execute(mockFacts);
    }
}
