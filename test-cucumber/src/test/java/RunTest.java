import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps", "hooks"}
)
public class RunTest {

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

}
