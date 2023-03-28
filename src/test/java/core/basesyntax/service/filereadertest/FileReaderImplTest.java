package core.basesyntax.service.filereadertest;

import core.basesyntax.service.filereader.FileReader;
import core.basesyntax.service.filereader.FileReaderImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderImplTest {
    private static FileReader fileReader;
    private static List<String> stringDataFromFile;
    private static final String INPUT_TEST_FILE_OK = "src/test/resources/inputTest.csv";

    @BeforeClass
    public static void beforeClass() {
        fileReader = new FileReaderImpl();
        stringDataFromFile = new ArrayList<>();
    }

    @Test
    public void readFromFile_Ok() {
        stringDataFromFile.add("b,banana,20");
        stringDataFromFile.add("b,apple,100");
        stringDataFromFile.add("s,banana,100");
        stringDataFromFile.add("p,banana,13");
        stringDataFromFile.add("r,banana,2");
        List<String> dataFromFile = fileReader.dataFromFile(INPUT_TEST_FILE_OK);
        assertEquals(FileReaderImplTest.stringDataFromFile, dataFromFile);
    }

    @Test
    public void readFromFile_NotOk() {
        String fileNotExist = "src/test/resources/inputTest1234.csv";
        try {
            fileReader.dataFromFile(fileNotExist);
        } catch (RuntimeException e) {
            return;
        }
        fail("You should not be able to read from not existed file");
    }
}