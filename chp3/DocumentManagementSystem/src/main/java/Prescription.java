import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private String patientName;
    private String date;
    private final List<Drug> prescriptedDrug = new ArrayList<>();

    public void setPatientName(String name){
        this.patientName = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addDrug(Drug drug) {
        this.prescriptedDrug.add(drug);
    }

    public String getPatientName() {
        return this.patientName;
    }

    public String getDate() {
        return this.date;
    }

    public List<Drug> getPrescriptedDrugs() {
        return this.prescriptedDrug;
    }
}
