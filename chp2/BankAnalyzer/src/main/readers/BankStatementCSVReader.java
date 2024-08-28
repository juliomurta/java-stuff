package main.readers;

import main.contracts.BankStatementReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankStatementCSVReader implements BankStatementReader {
    @Override
    public List<String> readAllLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
