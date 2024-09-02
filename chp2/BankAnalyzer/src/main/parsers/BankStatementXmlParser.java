package main.parsers;

import main.contracts.BankStatementParser;
import main.BankTransaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementXmlParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(final String line) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final InputSource is = new InputSource(new StringReader(line));
        final Document document = builder.parse(is);
        final Element element = document.getDocumentElement();

        final LocalDate localDate = LocalDate.parse(element.getElementsByTagName("date")
                                                           .item(0)
                                                           .getTextContent(), DATE_PATTERN);

        final double amount = Double.parseDouble(element.getElementsByTagName("amount")
                                                        .item(0)
                                                        .getTextContent());

        final String description = element.getElementsByTagName("description")
                                          .item(0)
                                          .getTextContent();

        return new BankTransaction(localDate, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) throws Exception {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines) {
            final BankTransaction transaction = this.parseFrom(line);
            bankTransactions.add(transaction);
        }
        return bankTransactions;
    }
}
