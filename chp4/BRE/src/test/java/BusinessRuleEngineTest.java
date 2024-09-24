import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BusinessRuleEngineTest {

    @Test
    public void shouldRunAnonimousTask() {
        var facts = new Facts();
        facts.addFact("name", "Nate Higgers");
        facts.addFact("jobTitle", "CEO");

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
        businessRuleEngine.addRule(new Rule() {
            @Override
            public void perform(Facts facts1) {
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
        var mockAction = mock(Rule.class);
        var mockFacts = mock(Facts.class);
        var businessRuleEngine = new BusinessRuleEngine(mockFacts);
        businessRuleEngine.addRule(mockAction);
        businessRuleEngine.run();
        verify(mockAction).perform(mockFacts);
    }
}
