package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Slider tests")
public class SliderWidgetTest extends BaseTest {
    @Test(priority = 0, description = "Verification of links in slider elements")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verification of links in slider elements")
    @Story("Home page verification tests")
    public void verifySliderComponentsLinks(Method method) {
        startTest(method.getName(), "Scenario with links slider verifications");

        homePage.open()
                .sliderWidget()
                .verifyLinksInSlider();
    }

}
