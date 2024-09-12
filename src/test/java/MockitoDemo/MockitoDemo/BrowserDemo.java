package MockitoDemo.MockitoDemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Execution(CONCURRENT)
public class BrowserDemo {

    public String username = "LT_USERNAME";
    public String accesskey = "LT_ACCESS_KEY";

    public static RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    static String URL = "https://ecommerce-playground.lambdatest.io/";
    String chrome;

    @BeforeAll
    public static void start() {
        System.out.println("=======Starting junit 5 tests in LambdaTest  Grid========");
    }

    @BeforeEach
    public void setup(){
        System.out.println("=======Setting up drivers and browser========");
    }

    public void browser_setup(String browser) {
        System.out.println("Setting up the drivers and browsers");

        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("126.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "sripriyapkulkarni");
            ltOptions.put("accessKey", "NMt43ZDK7n5MrTZkp8NjsTXjiveSA4JPIGjUqvt3uwSbSwLAjo");
            ltOptions.put("project", "Junit Mockito Test");
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-testNG");
            browserOptions.setCapability("LT:Options", ltOptions);
            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (browser.equalsIgnoreCase("Firefox")) {

            FirefoxOptions browserOptions= new FirefoxOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("129");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "sripriyapkulkarni");
            ltOptions.put("accessKey", "NMt43ZDK7n5MrTZkp8NjsTXjiveSA4JPIGjUqvt3uwSbSwLAjo");
            ltOptions.put("project", "Untitled");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);

            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (browser.equalsIgnoreCase("Safari")) {

           SafariOptions  browserOptions= new SafariOptions();
            browserOptions.setPlatformName("macOS Sonoma");
            browserOptions.setBrowserVersion("17");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "sripriyapkulkarni");
            ltOptions.put("accessKey", "NMt43ZDK7n5MrTZkp8NjsTXjiveSA4JPIGjUqvt3uwSbSwLAjo");
            ltOptions.put("project", "Junit Mockito Safari");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);

            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }




    }



    @Test
    @MethodSource("browser")
    public void launchUrl_safari(){


        browser_setup("Safari");
        System.out.println(Thread.currentThread().getName());
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        String methodName = Thread.currentThread()
                .getStackTrace()[1]
                .getMethodName();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        System.out.println("The page title is "+actualTitle);
        String expectedTitle ="Your Store";
        System.out.println("Verifying the title of the webpage started");
        Assertions.assertEquals(expectedTitle, actualTitle);
        System.out.println("The webpage has been launched and the title of the webpage has been veriified successfully");
        System.out.println("********Execution of "+methodName+" has ended********");


    }

    @Test
    @MethodSource("browser")
    public void launchUrl_chrome(){

        browser_setup("Chrome");

        System.out.println(Thread.currentThread().getName());
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        String methodName = Thread.currentThread()
                .getStackTrace()[1]
                .getMethodName();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        System.out.println("The page title is "+actualTitle);
        String expectedTitle ="Your Store";
        System.out.println("Verifying the title of the webpage started");
        Assertions.assertEquals(expectedTitle, actualTitle);
        System.out.println("The webpage has been launched and the title of the webpage has been veriified successfully");
        System.out.println("********Execution of "+methodName+" has ended********");


    }

    @Test
    @MethodSource("browser")
    public void launchUrl_firefox(){


        browser_setup("Firefox");

        System.out.println(Thread.currentThread().getName());
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        String methodName = Thread.currentThread()
                .getStackTrace()[1]
                .getMethodName();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        System.out.println("The page title is "+actualTitle);
        String expectedTitle ="Your Store";
        System.out.println("Verifying the title of the webpage started");
        Assertions.assertEquals(expectedTitle, actualTitle);
        System.out.println("The webpage has been launched and the title of the webpage has been veriified successfully");
        System.out.println("********Execution of "+methodName+" has ended********");

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Quitting the browsers has started");
        driver.quit();
        System.out.println("Quitting the browsers has ended");
    }

    @AfterAll
    public static void end() {
        System.out.println("Tests ended");
    }
    static Stream<Arguments> browser() {
        return Stream.of(
                arguments("Chrome"),
                arguments("Firefox"),
                arguments("Safari")
        );
    }


}
















