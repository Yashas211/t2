import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WebPageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.get("https://yashas211.github.io/t2/");

        Thread.sleep(2000);
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();

        String expectedTitle = "Department of ICB";

        Assert.assertEquals(actualTitle, expectedTitle);

        assertTrue(actualTitle.contains("ICB"),
                "Title should contain 'ICB'");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();
    }
}
