package main.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.contracts.BankStatementReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankStatementJsonReader implements BankStatementReader {
    protected ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<String> readAllLines(final Path path) throws IOException {
        final File file = new File(path.toString());
        final JsonNode jsonNode = objectMapper.readTree(file);
        final List<String> lines = new ArrayList<>();
        for (Iterator<JsonNode> it = jsonNode.elements(); it.hasNext(); ) {
            final JsonNode element = it.next();
            lines.add(element.toPrettyString());
        }
        return lines;
    }
}
