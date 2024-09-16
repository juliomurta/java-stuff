import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String path = "target/classes/john-doe.presc";
        final File file = new File(path);
        final DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem(file);
        documentManagementSystem.printDocumentDetails();
    }
}
