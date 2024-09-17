import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrescriptionImporterTest {

    @Test
    public void shouldParseDocumentCorrectly() throws IOException {
        final String path = "target/classes/john-doe.presc";
        final File file = new File(path);
        final DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem(file);

        final Prescription prescription = documentManagementSystem.getPrescription();

        Assert.assertEquals("John Doe", prescription.getPatientName());
        Assert.assertEquals("2024-09-13", prescription.getDate());

        final List<Drug> drugs = prescription.getPrescriptedDrugs();
        Assert.assertEquals(5, drugs.size());

        final Drug drug1 = drugs.get(0);
        Assert.assertEquals("Gutallax", drug1.getName());
        Assert.assertEquals("1", drug1.getQuantity());
        Assert.assertEquals("twice a day", drug1.getDosage());

        final Drug drug2 = drugs.get(1);
        Assert.assertEquals("Aspirin", drug2.getName());
        Assert.assertEquals("2", drug2.getQuantity());
        Assert.assertEquals("once a day", drug2.getDosage());

        final Drug drug3 = drugs.get(2);
        Assert.assertEquals("Dipirona", drug3.getName());
        Assert.assertEquals("1", drug3.getQuantity());
        Assert.assertEquals("once every 6 hours", drug3.getDosage());

        final Drug drug4 = drugs.get(3);
        Assert.assertEquals("Suppository", drug4.getName());
        Assert.assertEquals("50", drug4.getQuantity());
        Assert.assertEquals("once every hour for a week", drug4.getDosage());

        final Drug drug5 = drugs.get(4);
        Assert.assertEquals("Desven", drug5.getName());
        Assert.assertEquals("7", drug5.getQuantity());
        Assert.assertEquals("once every day for a week", drug5.getDosage());
    }
}
