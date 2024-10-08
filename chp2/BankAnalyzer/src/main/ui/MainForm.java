package main.ui;

import main.BankStatementAnalyzer;
import main.BankStatementConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.parsers.BankStatementCSVParser;
import main.parsers.BankStatementJsonParser;
import main.parsers.BankStatementXmlParser;
import main.readers.BankStatementCSVReader;
import main.readers.BankStatementJsonReader;
import main.readers.BankStatementXmlReader;
import org.apache.commons.io.FilenameUtils;


public class MainForm extends JFrame {
    private JPanel contentPane;
    private JButton selectFileButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private  JFileChooser fileChooser;
    private static final int SAVE = 0;
    private BankStatementConfig statementConfig;

    public MainForm() {

        setTitle("Bank Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        textField1.setEnabled(false);
        textArea1.setEnabled(false);

        textField1.setDisabledTextColor(Color.BLACK);
        textArea1.setDisabledTextColor(Color.BLACK);

        fileChooser = new JFileChooser("C:\\Users\\Julio Murta\\source\\repos\\java-stuff\\chp2\\BankAnalyzer\\target\\classes");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        final List<String> allowedExtensions = new ArrayList<>();
        allowedExtensions.add("csv");
        allowedExtensions.add("xml");
        allowedExtensions.add("json");

        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final boolean result = fileChooser.showSaveDialog(null) == SAVE;
                if (result){
                    final File file = fileChooser.getSelectedFile();
                    final String path = file.getPath();
                    final String extension = FilenameUtils.getExtension(path);
                    if (allowedExtensions.contains(extension)) {
                        statementConfig = new BankStatementConfig(extension);
                        /*statementConfig.setSourceType(extension);
                        switch (extension) {
                            case "csv":
                                statementConfig.setReader(new BankStatementCSVReader());
                                statementConfig.setParser(new BankStatementCSVParser());
                                break;
                            case "json":
                                statementConfig.setReader(new BankStatementJsonReader());
                                statementConfig.setParser(new BankStatementJsonParser());
                                break;
                            case "xml":
                                statementConfig.setReader(new BankStatementXmlReader());
                                statementConfig.setParser(new BankStatementXmlParser());
                                break;
                        }*/

                        textField1.setText(path);
                        textArea1.setText("");
                        try {
                            final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(statementConfig);
                            final String summary = bankStatementAnalyzer.analyze(path);
                            textArea1.setText(summary);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,  ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null,  "File extension not allowed.", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setVisible(true);
    }
}
