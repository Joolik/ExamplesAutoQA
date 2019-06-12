package base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseWebComponent {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    // getTitle
    public String getPageTitle() {
        return driver.getTitle();
    }

}
