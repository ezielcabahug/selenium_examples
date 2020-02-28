package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverType;

import java.util.concurrent.TimeUnit;

public class NewScanPageTest {
    DriverManager driverManager;

    @Test
    public void NewScan() {
        driverManager.getWebDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driverManager.getWebDriver().get("https://portal01.test.usa.net/");
        WebElement username = driverManager.getWebDriver().findElement(By.xpath("//input[@name='username']"));
        WebElement password = driverManager.getWebDriver().findElement(By.cssSelector("#password"));
        WebElement loginBtn = driverManager.getWebDriver().findElement(By.className("btn"));

        username.sendKeys("qa_test_stage@perimeterusa.com");
        password.sendKeys("Password5");
        loginBtn.click();

        WebElement newScanBtn = driverManager.getWebDriver().findElement(By.linkText("NEW SCAN"));
        newScanBtn.click();
    }

    @BeforeClass
    public void beforeClass() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
    }

    @AfterClass
    public void afterClass() {
        driverManager.quitWebDriver();
    }
}
