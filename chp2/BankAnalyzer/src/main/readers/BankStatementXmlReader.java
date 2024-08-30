package main.readers;

import main.contracts.BankStatementReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class BankStatementXmlReader implements BankStatementReader {
    @Override
    public List<String> readAllLines(Path path) throws IOException {
        return List.of();
    }
}
