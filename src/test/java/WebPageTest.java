import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public class WebPageTest {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser() throws Exception {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new RemoteWebDriver(
                new URL("http://localhost:9515"),
                options
        );

        driver.get("https://yashas211.github.io/t2/");

        Thread.sleep(3000);
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();

        System.out.println("Actual Title: " + actualTitle);

        assertTrue(actualTitle.length() > 0);
    }

    @AfterTest
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
