package main.readers;

import main.contracts.BankStatementReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankStatementCSVReader implements BankStatementReader {
    @Override
    public List<String> readAllLines(final Path path) throws Exception {
        return Files.readAllLines(path);
    }
}
