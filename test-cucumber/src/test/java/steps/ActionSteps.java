package steps;

import cucumber.api.java.en.When;

public class ActionSteps extends StepBackground {

    @When("^Search text '([^\"]*)'$")
    public void searchText(String text) {
        homePage.search(text);
    }
}
