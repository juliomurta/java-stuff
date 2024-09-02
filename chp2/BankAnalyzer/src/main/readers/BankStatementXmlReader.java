package main.readers;

import main.contracts.BankStatementReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BankStatementXmlReader implements BankStatementReader {
    @Override
    public List<String> readAllLines(final Path path) throws Exception {
        final List<String> lines = new ArrayList<>();
        final File file = new File(path.toString());
        final DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
        final Document document = xmlBuilder.parse(file);
        final NodeList nodes = document.getDocumentElement()
                                       .getElementsByTagName("transaction");
        for (int i = 0; i < nodes.getLength(); i++) {
            final Node node = nodes.item(i);
            lines.add(nodeToString(node));
        }
        return lines;
    }

    private String nodeToString(Node node) throws Exception {
        StringWriter sw = new StringWriter();
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(node), new StreamResult(sw));

        return sw.toString();
    }
}
