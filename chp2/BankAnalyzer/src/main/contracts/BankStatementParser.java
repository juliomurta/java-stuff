package main.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import main.BankTransaction;

import java.io.IOException;
import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line) throws IOException;
    List<BankTransaction> parseLinesFrom(List<String> lines) throws IOException;
}
