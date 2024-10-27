package MockitoDemo.MockitoDemo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowserDemo {
    String username = System.getenv("LT_USERNAME") == null ?
            "LT_USERNAME" : System.getenv("LT_USERNAME");
    String accesskey = System.getenv("LT_ACCESS_KEY") == null ?
            "LT_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY");

    public String username = "username";
    public String accesskey = "accesskey";

    public static RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status = "failed";
    static String URL = "https://ecommerce-playground.lambdatest.io/";

    @AfterAll
    public void end() {
        System.out.println("Tests ended");
    }

    public static Stream<String> browserProvider()
    {
        return Stream.of("Chrome", "Firefox", "Safari");
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    public void launchUrl(String browser)
    {
        browser_setup(browser);

        driver.navigate().to(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String actualTitle = driver.getTitle();
        System.out.println("The page title is " + actualTitle);
        String expectedTitle = "Your Store";

        /* The status variable is used for updating status on LambdaTest dashboard */
        try
        {
            assertEquals(expectedTitle, actualTitle);
            status = "passed";
            System.out.println("Title verification successful");
        }
        catch (AssertionError e)
        {
            status = "failed";
            System.out.println("Title verification failed: " + e.getMessage());
        }
    }

    public void browser_setup(String browser)
    {
        System.out.println("Setting up drivers for browser: " + browser);
        try
        {
            if (browser.equalsIgnoreCase("Chrome"))
            {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("129");
                HashMap<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", "username");
                ltOptions.put("accessKey", "accessKey");
                ltOptions.put("build", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("name", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("w3c", true);
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(browserOptions);
            }
            else if (browser.equalsIgnoreCase("Firefox"))
            {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("131");
                HashMap<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", "username");
                ltOptions.put("accessKey", "accessKey");
                ltOptions.put("build", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("name", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("w3c", true);
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(browserOptions);
            }
            else if (browser.equalsIgnoreCase("Safari"))
            {
                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setPlatformName("MacOS Sequoia");
                browserOptions.setBrowserVersion("18");
                HashMap<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", "username");
                ltOptions.put("accesskey", "accesskey");
                ltOptions.put("build", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("name", "[" + browser +"] JUnit Mockito Test");
                ltOptions.put("w3c", true);
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(browserOptions);
            }
        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void tearDown()
    {
        System.out.println("Quitting the browser");
        if (driver != null)
        {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status + "");
            driver.quit();
        }
    }
}
