package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ActionsTest {
    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String myURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    private WebDriver driver;

    @Before
    public void before() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("name", "Actions Simple Test");
        browserOptions.setCapability("browserName", "firefox");
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "83.0");
        sauceOptions.setCapability("screenResolution", "1280x1024");
        sauceOptions.setCapability("name","Actions Simple Test w screen res");
        browserOptions.setCapability("sauce:options", sauceOptions);
        System.out.println("Capabilities = " + browserOptions);
        driver = new RemoteWebDriver(new URL(myURL), browserOptions);
    }

    @Test
    public void reachTheWebsite() {
        driver.get("https://www.amazon.com");
        Actions act = new Actions(driver);
        //act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        act.moveToElement(driver.findElement(By.id("nav-link-prime"))).click().build().perform();
    }

    @After
    public void after() {
        driver.quit();
    }
}
