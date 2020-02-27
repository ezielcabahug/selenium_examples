package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NewScanTest {
    public WebDriver driver;

    @Test
    public void NewScan() {
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://portal01.test.usa.net/");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtn = driver.findElement(By.className("btn"));

        username.sendKeys("qa_test_stage@perimeterusa.com");
        password.sendKeys("Password5");
        loginBtn.click();

        WebElement newScanBtn = driver.findElement(By.linkText("NEW SCAN"));
        newScanBtn.click();
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
