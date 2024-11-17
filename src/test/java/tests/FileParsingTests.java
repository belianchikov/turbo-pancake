package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import model.Aircraft;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.List;


public class FileParsingTests {
    private final ClassLoader cl = FileParsingTests.class.getClassLoader();
    private static final ObjectMapper om = new ObjectMapper();

    @Test
    void pdfFileParsingTest() throws Exception {
        PDF pdf = null;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("file-sample_150kB.pdf")) {
                    pdf = new PDF(zis);
                    break;
                }
            }
            Assertions.assertTrue(pdf.text
                    .contains("Lorem ipsum dolor sit amet, consectetur adipiscing"));
        }
    }


    @Test
    void xlsFileParsingTest() throws Exception {
        XLS xls = null;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("file_example_XLS_10.xls")) {
                    xls = new XLS(zis);
                    break;
                }
            }
            Assertions.assertTrue(xls.excel.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue()
                    .contains("Magwood"));
        }
    }

    @Test
    void csvFileParsingTest() throws Exception {
        CSVReader csvReader = null;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("file_example_CSV_5000.csv")) {
                    csvReader = new CSVReader(new InputStreamReader(zis));
                    break;
                }
            }

            List<String[]> data = csvReader.readAll();
            Assertions.assertEquals(5001, data.size());
            Assertions.assertArrayEquals(
                    new String[]{"18", "Lauralee", "Perrine", "Female", "Great Britain", "28", "16/08/2016", "6597"},
                    data.get(18)
            );
            Assertions.assertArrayEquals(
                    new String[]{"7", "Etta", "Hurn", "Female", "Great Britain", "56", "15/10/2017", "3598"},
                    data.get(7)
            );
        }
    }

    @Test
    void jsonFileParsingTest() throws IOException {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("aircraft.json")
        )) {

            Aircraft aircraft = om.readValue(reader, Aircraft.class);

            Assertions.assertEquals("Airbus", aircraft.getManufacturer());
            Assertions.assertEquals("A320neo", aircraft.getModel());
            Assertions.assertEquals(6300, aircraft.getRangeKm());
            Assertions.assertEquals(194, aircraft.getMaxPassengers());
            Assertions.assertEquals(17, aircraft.getDimensions().getHeight());
            Assertions.assertEquals("Enhanced fuel efficiency", aircraft.getFeatures().get(0));
        }
    }
}