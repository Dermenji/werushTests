package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.logs.Log;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests are starting!");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }

}
