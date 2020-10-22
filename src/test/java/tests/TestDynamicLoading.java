package tests;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.DynamicLoading;

import org.junit.experimental.categories.Category;
import tests.groups.Deep;

import static org.junit.Assert.assertTrue;

@Category(Deep.class)
public class TestDynamicLoading extends BaseTest {

//    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/aleksandrashineleva/Documents/chromedriver");
//        ChromeOptions browserOptions = new ChromeOptions();
//        driver = new ChromeDriver();
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }

    @Test
    public void elementAppears() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }
}
