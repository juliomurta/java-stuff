import java.util.HashMap;
import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    Document(final Map<String, String> attrs) {
        this.attributes = attrs;
    }

    public String getAttribute(final String name) {
        return this.attributes.get(name);
    }

    public int count(final String name) {
        int count = 0;
        for (final String attr: this.attributes.keySet()) {
            if (attr.toLowerCase().contains(name.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
