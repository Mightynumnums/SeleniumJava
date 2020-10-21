
//filename: tests/TestLogin.java
package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.Login;
import static org.junit.Assert.assertTrue;

public class TestLogin {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandrashineleva/Documents/chromedriver");
        ChromeOptions browserOptions = new ChromeOptions();
        driver = new ChromeDriver(/*browserOptions*/);
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
//        driver.get("http://the-internet.herokuapp.com/login");
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("button")).click();
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present", login.successMessagePresent());
//        Assert.assertTrue("success message not present",
//                driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }

    @Test
    public void failed() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present",
        login.successMessagePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
