import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import entities.User;

public class LoginPage extends BasePage {

    public static final String PAGE_TITLE = "MantisBT";

    private WebElement username;

    private WebElement password;

    @FindBy(css = ".btn-success")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
        this.username.sendKeys(user.getUsername());
        btnLogin.click();
        this.password.sendKeys(user.getPassword());
        btnLogin.click();
    }
}
