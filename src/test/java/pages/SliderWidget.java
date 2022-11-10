package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.logs.Log;

import java.util.ArrayList;
import java.util.List;


public class SliderWidget extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    public SliderWidget(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".slider-wrapper")
    public WebElement wrapper;

    @FindBy(css = ".home-slider__slide-wrapper")
    public List<WebElement> test;


    @Step
    public void verifyLinksInSlider() {
        Log.info("Trying to verify slider links");
        waitVisibilityElement(wrapper);
        List<String> linkPath = new ArrayList<>();

        for (WebElement a : test) {
            try {
                linkPath.add(a.findElement(By.cssSelector(".btn")).getAttribute("href"));
            } catch (StaleElementReferenceException e) {
            }
        }

        for (String path : linkPath) {
            softAssert.assertTrue(!path.contains("404"), path + " - Url contains 404 error");
        }

        softAssert.assertAll();
    }


}
