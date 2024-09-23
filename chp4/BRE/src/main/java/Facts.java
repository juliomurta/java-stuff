import java.util.HashMap;

public class Facts {
    private final HashMap<String, String> facts = new HashMap<>();

    public String getFact(String key){
        return this.facts.get(key);
    }

    public void addFact(String key, String value) {
        this.facts.put(key, value);
    }
}
