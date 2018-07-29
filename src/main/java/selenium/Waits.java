package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Waits {
    FirefoxDriver driver = new FirefoxDriver();

    @Test
    public void fluint() {
        WebElement ele = driver.findElement(By.name("hai"));
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebDriverWait waait = new WebDriverWait(driver, 21);
        waait.until(ExpectedConditions.elementToBeClickable(By.className("hello")));
    }
}
