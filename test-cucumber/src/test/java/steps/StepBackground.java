package steps;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class StepBackground {

    static final String HOME_PAGE_URL = "https://habr.com/ru/";

    static HomePage homePage;

    protected WebDriver driver;

    protected StepBackground() {
        driver = TestContext.getInstance().getDriver();
    }
}
