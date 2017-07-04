package appium;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kranthi on 03-07-2017.
 */
public class ApplicationInterface {
    DesiredCapabilities dc;
    AndroidDriver<WebElement> driver;
    Logger log = Logger.getLogger(ApplicationInterface.class);
    private String str;

    @Test(enabled = false)
    public void f1() throws Exception {
        driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator(
                "UiSelector().className(\"android.widget.TextView\").instance(8)").click();

        Thread.sleep(3000);
        String str=driver.getPageSource();
        System.out.println(str);
        File f=new File("D:\\PageSource.xml");
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(str);
        bw.close();
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document d=db.parse(f);
        NodeList nl=d.getElementsByTagName("android.widget.LinearLayout");
        System.out.println(nl.getLength());
        for (int i = 0; i < nl.getLength(); i++) {
            Element e=(Element)nl.item(i);
            System.out.println(e.getAttribute("content-desc"));
        }

    }

}
