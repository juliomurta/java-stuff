
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Facts {
    private final HashMap<String, String> facts = new HashMap<>();
    private final JSONParser parser = new JSONParser();

    public String getFact(String key){
        return this.facts.get(key);
    }

    public void addFact(String key, String value) {
        this.facts.put(key, value);
    }

    public void loadFacts(File file) throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));

        for (Object entry : jsonObject.entrySet()) {
            Map.Entry<String, String> row = (Map.Entry<String, String>) entry;
            this.addFact(row.getKey(), row.getValue());
        }
    }
}
