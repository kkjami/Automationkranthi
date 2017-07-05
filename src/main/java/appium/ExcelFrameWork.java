package appium;

import io.appium.java_client.android.AndroidDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


/**
 * Created by Kranthi on 01-07-2017.
 */
public class ExcelFrameWork {

    private DesiredCapabilities desiredcapabilites;
    private AndroidDriver<WebElement> driver;
    private final static Logger log = Logger.getLogger(ExcelFrameWork.class);

    @BeforeTest
    public void setup() {
        File file = new File("src\\main\\resources\\com.android.chrome_58.0.3029.83-302908311_minAPI21(x86)(nodpi)" +
                "_apkmirror.com.apk");
        desiredcapabilites = new DesiredCapabilities();
        desiredcapabilites.setCapability("deviceName", "AEmulator");
        desiredcapabilites.setCapability("platformVersion", "6.0");
        desiredcapabilites.setCapability("platformName", "Android");
        desiredcapabilites.setCapability("browserName", "Chrome");
//        desiredcapabilites.setCapability("file",file.getAbsolutePath());
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void executingExcelTests() throws IOException, BiffException {
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilites);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
                if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("url")) {
                    driver.get(testsheet.getCell(0, b).getContents());
                } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("click")) {
                    driver.findElement(By.id(testsheet.getCell(0, b).getContents())).click();
                } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("link")) {
                    driver.findElement(By.linkText(testsheet.getCell(0, b).getContents())).click();
                } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("wait")) {
//                    Thread.sleep(testsheet.getCell(0, b).getContents()));
                    //TO-DO check with rames non string and string excel vlues.
                } else if (testsheet.getCell(2, b).getContents().equalsIgnoreCase("textbox")) {
                    driver.findElement(By.id(testsheet.getCell(0, b).getContents())).sendKeys(testsheet.getCell(3, b).getContents());
                }
                //TO-DO incomplete need to do.
            }
        }
    }
}
