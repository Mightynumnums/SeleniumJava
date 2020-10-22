package tests;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.Login;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import tests.groups.Shallow;
// line above with * means import all Asserts

public class TestLogin extends BaseTest {

//    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/aleksandrashineleva/Documents/chromedriver");
//        ChromeOptions browserOptions = new ChromeOptions();
//        driver = new ChromeDriver(/*browserOptions*/);
//        login = new Login(driver);
        login = new Login(driver);
    }

    @Test
    @Category(Shallow.class)
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present", login.successMessagePresent());
    }

//    @Test
//    public void failed() {
//        login.with("tomsmith", "SuperSecretPassword!");
//        assertTrue("success message not present",
//        login.failureMessagePresent());
//    }

    @Test
    @Category(Shallow.class)
    public void failed() {
        login.with("tomsmith", "badpassword");
        assertFalse("success message was present after providing bogus credentials", login.successMessagePresent());
    }
}

