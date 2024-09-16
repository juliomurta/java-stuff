import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrescriptionImporter implements Importer {

    private class Drug {
        final String name;
        final String quantity;
        final String dosage;

        Drug(final String name, final String quantity, final String dosage) {
            this.name = name;
            this.quantity = quantity;
            this.dosage = dosage;
        }

        public String getName() {
            return this.name;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public String getDosage() {
            return this.dosage;
        }
    }

    private static final String PATH = "path";
    private static final String DATE = "date";
    private static final String PATIENT = "patient";
    private static final String DRUG = "drug";
    private static final String DRUG_NAME = "name";
    private static final String DRUG_QUANTITY = "quantity";
    private static final String DRUG_DOSAGE = "dosage";
    private static final String TYPE = "type";

    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        attributes.put(TYPE, "PRESCRIPTION");

        final String content = Files.readString(Path.of(attributes.get(PATH)));

        final String date = extractValueTag(DATE, content);
        attributes.put(DATE, date);

        final String patientName = extractValueTag(PATIENT, content);
        attributes.put(PATIENT, patientName);

        final List<Drug> drugs = extractDrugs(content);
        for (int i = 0; i < drugs.size(); i++) {
            final Drug drug = drugs.get(i);
            attributes.put(DRUG_NAME + i, drug.getName());
            attributes.put(DRUG_QUANTITY + i, drug.getQuantity());
            attributes.put(DRUG_DOSAGE + i, drug.getDosage());
        }

        return new Document(attributes);
    }

    private List<Drug> extractDrugs(String content) {
        final List<Drug> drugs = new ArrayList<>();
        while(content.contains(DRUG.toUpperCase())) {
            final String drugTagContent = extractValueTag(DRUG, content);

            final String drugName = extractValueTag(DRUG_NAME, drugTagContent);
            final String drugQuantity = extractValueTag(DRUG_QUANTITY, drugTagContent);
            final String drugDosage = extractValueTag(DRUG_DOSAGE, drugTagContent);
            drugs.add(new Drug(drugName, drugQuantity, drugDosage));

            final String drugTag = "<" + DRUG.toUpperCase() + ">" + drugTagContent + "</" + DRUG.toUpperCase() + ">";
            content = content.replace(drugTag, "");
        }
        return drugs;
    }

    private String extractValueTag(String tagName, String content) {
        tagName = tagName.toUpperCase();

        final String[] foundTag = content.split("<" + tagName + ">");
        if(foundTag.length == 0) {
            return "";
        }

        final String[] foundClosingTag = foundTag[1].split("</" + tagName + ">");
        if(foundClosingTag.length == 0) {
            return "";
        }
        return foundClosingTag[0];
    }
}
