package appium;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Kranthi on 01-07-2017.
 */
public class ExcelFrameWorkForWeb extends CommonToolsForWeb {

    private final static Logger log = Logger.getLogger(ExcelFrameWorkForWeb.class);
    String str;

    @Test
    public void executingExcelTests() throws IOException, BiffException, WriteException {
        FileInputStream sourceexcelfile = new FileInputStream("src\\main\\resources\\scriptSheet.xml");
        Workbook sourceworkbook = Workbook.getWorkbook(sourceexcelfile);
        FileOutputStream resultexcelfle = new FileOutputStream("target\\resultSheet.xml");
        WritableWorkbook resultworkbook = Workbook.createWorkbook(resultexcelfle);
        String names[] = sourceworkbook.getSheetNames();
        for (int c = 0; c < names.length; c++) {
            log.info("Executing tests as in sheet" + names[c]);
            Sheet testsheet = sourceworkbook.getSheet(c);
            WritableSheet resultsheet = resultworkbook.createSheet(names[c], c);
            for (int b = 0; b < testsheet.getRows(); b++) {
                try {
                    if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("url")) {
                        driver.get(testsheet.getCell(0, b).getContents());
                        log.info("opening URL as in step :"+b);
                    } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("click")) {
                        driver.findElement(By.id(testsheet.getCell(0, b).getContents())).click();
                        log.info("clickin button as in step :"+b);
                    } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("link")) {
                        driver.findElement(By.linkText(testsheet.getCell(0, b).getContents())).click();
                        log.info("Clicking link as in step :"+b);
                    } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("wait")) {
                        Thread.sleep(2000);
                        log.info("pausing execution for 2000ms");
                        // Thread.sleep(testsheet.getCell(0, b).getContents()));
                        //TODO check with rames non string and string excel vlues.
                    } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("textbox")) {
                        driver.findElement(By.id(testsheet.getCell(0, b).getContents())).sendKeys(testsheet.getCell(3, b).getContents());
                        log.info("entering text into textinput as in step :"+b);
                    }
                    //TODO incomplete need to do.
                    str = "Pass";
                } catch (Exception e) {
                    str = "Fail";
                }
                Label result = new Label(4, b, str);
                resultsheet.addCell(result);
                for (int i = 0; i < testsheet.getColumns(); i++) {
                    Label testdata = new Label(i, b, testsheet.getCell(i, b).getContents());
                    resultsheet.addCell(testdata);
                }

            }
            Label or = new Label(0, 0, "Object Repository");
            Label dn = new Label(1, 0, "DisplayName");
            Label at = new Label(2, 0, "Action Type");
            Label td = new Label(3, 0, "TestData");
            Label rs = new Label(4, 0, "Result");
            resultsheet.addCell(or);
            resultsheet.addCell(dn);
            resultsheet.addCell(at);
            resultsheet.addCell(td);
            resultsheet.addCell(rs);

        }
        resultworkbook.close();
        sourceworkbook.close();
    }
}
