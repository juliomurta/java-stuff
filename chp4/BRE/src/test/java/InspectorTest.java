import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InspectorTest {

    @Test
    public void inspectOneConditionEvaluatesTrue() {
        final Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");

        final ConditionalAction conditionalAction = new JobTitleCondition();

        final Inspector inspector = new Inspector(conditionalAction);

        final List<Report> reportList = inspector.inspect(facts);

        Assert.assertEquals(1, reportList.size());
        Assert.assertEquals(true, reportList.get(0).getIsPositive());
    }
}
