import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {
    private final Map<String, Importer> extensionsToImporter = new HashMap<>();
    private final File file;

    public DocumentManagementSystem(File file) {

        this.file = file;
        //extensionsToImporter.put("letter", new LetterImporter());
        //extensionsToImporter.put("report", new ReportImporter());
        this.extensionsToImporter.put("jpg", new ImageImporter());
        this.extensionsToImporter.put("presc", new PrescriptionImporter());
    }

    public Prescription getPrescription() throws IOException {
        final String filename = file.getName();
        final String extension = filename.substring(filename.lastIndexOf('.') + 1);
        final Importer importer = this.extensionsToImporter.get(extension);

        Document document = importer.importFile(file);
        String patientName = document.getAttribute("patient");
        String date = document.getAttribute("date");

        Prescription prescription = new Prescription();
        prescription.setPatientName(patientName);
        prescription.setDate(date);

        final int prescribedDrugs = document.count("name");
        for(int i = 0; i < prescribedDrugs; i++) {
            final String drugName = document.getAttribute("name" + i);
            final String drugQuantity = document.getAttribute("quantity" + i);
            final String drugDosage = document.getAttribute("dosage" + i);
            prescription.addDrug(new Drug(drugName, drugQuantity, drugDosage));
        }

        return prescription;
    }

    public void printDocumentDetails() throws IOException {
        final Prescription prescription = this.getPrescription();
        System.out.println("O nome do paciente é: " + prescription.getPatientName());
        System.out.println("Data da receita: " + prescription.getDate());

        System.out.println("============= Prescrição =============");
        for (final Drug drug : prescription.getPrescriptedDrugs()) {

            final String drugName = drug.getName();
            final String drugQuantity = drug.getQuantity();
            final String drugDosage = drug.getDosage();

            System.out.println("Nome: " + drugName);
            System.out.println("Quantidade: " + drugQuantity);
            System.out.println("Posologia: " + drugDosage);
            System.out.println("--------------------------------------------------------------------");
        }
    }
}
