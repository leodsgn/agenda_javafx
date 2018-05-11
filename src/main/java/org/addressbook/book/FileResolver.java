package org.addressbook.book;

import com.google.common.io.Files;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileResolver {
    private static final String FILE_PATH = "database.txt";
    private static final File FILE = new File(FILE_PATH);
    private static final String DELIMITER = ";";
    private static FileResolver instance;

    public static synchronized FileResolver getInstance() {
        if (instance == null) {
            instance = new FileResolver();
        }
        return instance;
    }

    // TODO: implement file writer
    public boolean writeData(Person person) {
        try {
            if (!FILE.exists()) FILE.createNewFile();

            String line = person.getName() + DELIMITER +
                    person.getAddress() + DELIMITER +
                    person.getAddress_2() + DELIMITER +
                    person.getCity() + DELIMITER +
                    person.getState() + DELIMITER +
                    person.getPhone();

            String tmp = "";

            FileUtils.writeStringToFile(FILE, line + "\r\n", StandardCharsets.UTF_8, true);

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public ObservableList<Person> getData() {
        if (FILE.exists()) {
            ObservableList<Person> personList = FXCollections.observableArrayList();
            try {
                if (FILE.length() <= 0) throw new Exception("Empty file.");
                Files.readLines(FILE, Charset.defaultCharset()).forEach(line -> {
                    String attrs[] = line.split(DELIMITER);
                    Person p = new Person(attrs[0], attrs[1], attrs[2], attrs[3], attrs[4], attrs[5]);

                    System.out.println("nome: " + p.getName());
                    System.out.println("telefone: " + p.getPhone());

                    personList.add(
                            new Person(attrs[0], attrs[1], attrs[2], attrs[3], attrs[4], attrs[5])
                    );
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(personList.toString());
            return personList;
        }
        return null;
    }
}
