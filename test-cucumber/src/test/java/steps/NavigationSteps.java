package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;

public class NavigationSteps extends StepBackground {

    @Given("^Open site habr$")
    public void openSite() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }
}
