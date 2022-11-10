package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://test:werushtest@test.werush.co/";

    @Step
    public HomePage open() {
        Log.info("Opening application");
        driver.get(baseURL);
        return this;
    }

    @Step
    public SliderWidget sliderWidget() {
        return new SliderWidget(driver);
    }
}
