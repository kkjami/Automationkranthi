package appium;

import io.appium.java_client.android.AndroidDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
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
import java.util.concurrent.TimeUnit;

/**
 * Created by Kranthi on 01-07-2017.
 */
public class GetHTMLSource_PrintAttributes {
    DesiredCapabilities dc;
    AndroidDriver<WebElement> driver;
    Logger log = Logger.getLogger(GetHTMLSource_PrintAttributes.class);
    private String str;

    @BeforeTest
    public void setup() {
        dc = new DesiredCapabilities();
        dc.setCapability("PlatformVersion", "6.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "AEmulator");
//      dc.setCapability("appPackage","");
//      dc.setCapability("appActivity","");
        dc.setCapability("browserName", "Browser");
    }

    @AfterTest
    public void teardown() {
        //driver.closeApp();
        driver.quit();
    }

    @Test(enabled = false)
    public void gettingSource() {
        try {
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            log.error(e.getStackTrace() + "\n unable to connect Appium Server");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://facebook.com");
//        driver.findElementById("login");
    }
    @Test(enabled = false)
    public void f() throws Exception {
        driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://selenium4testing.com");
        driver.findElement(By.id("closediv")).click();
        driver.findElementByLinkText("Manual FAQs");
        driver.findElementByLinkText("Selenium FAQs");
        driver.findElementByLinkText("General Testing FAQs");
    }
    @Test(enabled = false)
    public void f2() throws Exception {
        driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FileInputStream fi=new FileInputStream(".\\Testdata\\WebappData.xls");
        Workbook w=Workbook.getWorkbook(fi);

        FileOutputStream fo=new FileOutputStream(".\\Results\\WebappResults.xls");
        WritableWorkbook wb=Workbook.createWorkbook(fo);
        String names[]=w.getSheetNames();
        System.out.println(names.length);
        for(int c=0; c<names.length; c++){
            Sheet s=w.getSheet(c);
            WritableSheet ws=wb.createSheet("Results"+c, c);
            for (int i = 1; i < s.getRows(); i++) {
                try{
                    if(s.getCell(2, i).getContents().equalsIgnoreCase("url"))
                    {
                        driver.get(s.getCell(0, i).getContents());
                    }
                    else if(s.getCell(2, i).getContents().equalsIgnoreCase("click"))
                    {
                        driver.findElement(By.id(s.getCell(0, i).getContents())).click();
                    }
                    else if(s.getCell(2, i).getContents().equalsIgnoreCase("link"))
                    {
                        driver.findElement(By.linkText(s.getCell(0, i).getContents())).click();
                    }
                    else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait"))
                    {
                        Thread.sleep(2000);
                    }
                    else if(s.getCell(2, i).getContents().equalsIgnoreCase("textbox"))
                    {
                        driver.findElement(By.id(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
                    }
                    str="Pass";
                }catch(Exception e){str="Fail";}
                Label result=new Label(4,i, str);
                ws.addCell(result);


                for (int j = 0; j < s.getColumns(); j++) {
                    System.out.println(s.getCell(j, i).getContents());
                    Label l=new Label(j, i, s.getCell(j, i).getContents());
                    ws.addCell(l);
                }

            }
            Label or=new Label(0,0,"Object Repository");
            Label dn=new Label(1,0,"DisplayName");
            Label at=new Label(2,0,"Action Type");
            Label td=new Label(3,0,"TestData");
            Label rs=new Label(4,0,"Result");
            ws.addCell(or);
            ws.addCell(dn);
            ws.addCell(at);
            ws.addCell(td);
            ws.addCell(rs);
        }
        wb.write();
        wb.close();
    }
    @Test
    public void test() throws Exception {
        File f=new File("D:\\Whats app\\WhatsApp.apk");
        DesiredCapabilities dc=new DesiredCapabilities();
        //dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        dc.setCapability("deviceName", "Nagesh");
        dc.setCapability("platformVersion", "4.4.4");
        dc.setCapability("platformName", "Android");
        //dc.setCapability("browserName", "Chrome");
        //dc.setCapability("f", f.getAbsolutePath());

        dc.setCapability("appPackage", "com.sec.android.app.launcher");
        dc.setCapability("appActivity", "com.android.launcher2.Launcher");
        dc.setCapability("f",f.getAbsolutePath());
        //driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Phone']")).click();

        driver.findElement(By.id("com.android.contacts:id/nine")).click();
        driver.findElement(By.id("com.android.contacts:id/eight")).click();
        driver.findElement(By.id("com.android.contacts:id/four")).click();
        driver.findElement(By.id("com.android.contacts:id/eight")).click();
        driver.findElement(By.id("com.android.contacts:id/seven")).click();
        driver.findElement(By.id("com.android.contacts:id/three")).click();
        driver.findElement(By.id("com.android.contacts:id/four")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/nine")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/five")).click();
        driver.findElement(By.id("com.android.contacts:id/callbutton")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.Button[@text='End call']")).click();
    }

}
