import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipTest {
    private ClassLoader cl = ReadingZipTest.class.getClassLoader();

    @Test
    void readFilesFromZip() throws Exception {
        try (InputStream zipFile = cl.getResourceAsStream("TestData.zip");
             ZipInputStream filesFromZip = new ZipInputStream(zipFile)) {
            ZipEntry entry;
            while ((entry = filesFromZip.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(filesFromZip);
                    Assertions.assertTrue(pdf.text.startsWith("Test data for homework for lesson 8"));
                }

                if (entry.getName().contains(".xlsx")) {
                    XLS xls = new XLS(filesFromZip);
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(3).getCell(2)
                            .getStringCellValue(), "training");

                }

                if (entry.getName().contains(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(filesFromZip));
                    List<String[]> csvContent = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[]{"9", "test"}, csvContent.get(9));

                }
            }

        }
    }
}