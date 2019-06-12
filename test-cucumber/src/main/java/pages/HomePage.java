package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "search-form-btn")
    private WebElement searchButton;

    @FindBy(id = "search-form-field")
    private WebElement searchField;

    @FindBy(css = "div.post__text")
    private List<WebElement> foundText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void pressSearchButton() {
        searchButton.click();
    }

    private void fillSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void search(String searchText) {
        pressSearchButton();
        fillSearchField(searchText);
        searchField.click();
        searchField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getFoundText() {
        return foundText;
    }

}
