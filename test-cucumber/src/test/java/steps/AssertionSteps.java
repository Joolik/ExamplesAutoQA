package steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AssertionSteps extends StepBackground {

    @Then("^Search results should contain '([^\"]*)'")
    public void checkSearchResults(String text) {
        for (WebElement foundText : homePage.getFoundText()) {
            assertThat(foundText.getText().toLowerCase(), containsString(text.toLowerCase()));
        }
    }


}
