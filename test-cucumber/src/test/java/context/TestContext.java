package context;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;

    private static TestContext context;

    private TestContext() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static TestContext getInstance() {
        if (context == null) {
            context = new TestContext();
        }
        return context;
    }
}
