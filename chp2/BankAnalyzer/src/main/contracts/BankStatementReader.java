package main.contracts;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface BankStatementReader {
    List<String> readAllLines(Path path) throws Exception;
}
