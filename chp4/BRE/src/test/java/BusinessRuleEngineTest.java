import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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

    @Test
    public void loadFactsFromJson() throws IOException, ParseException {
        final File file = new File("C:\\Users\\Julio Murta\\source\\repos\\java-stuff\\chp4\\BRE\\src\\main\\resources\\facts.json");
        final Facts facts = new Facts();
        facts.loadFacts(file);
        Assert.assertEquals("X", facts.getFact("A"));
        Assert.assertEquals("Y", facts.getFact("B"));
        Assert.assertEquals("Z", facts.getFact("C"));
    }
}
