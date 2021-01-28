package tests;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class GetCookiesSLTest {
    public static final String baseUrl = System.getProperty("baseUrl", "http://amazon.com");
    public static final String host = System.getProperty("host", "saucelabs");
    public static final String browserName = System.getProperty("browserName", "chrome");
    public static final String browserVersion = System.getProperty("browserVersion", "87");
//    public static final String platformName = System.getProperty("platformName", "macOS 11.00");
public static final String platformName = System.getProperty("platformName", "Windows 10");
    public static final String sauceUser = System.getenv("SAUCE_USERNAME");
    public static final String sauceKey = System.getenv("SAUCE_ACCESS_KEY");
    public static final String sauceTunnel = System.getenv("SAUCE_TUNNEL");

    public static final String URL = "https://" + sauceUser+ ":" + sauceKey + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        //ChromeOptions browserOptions = new ChromeOptions();

        ChromeOptions caps = new ChromeOptions();

        caps.setCapability("platformName", platformName);
        caps.setCapability("browserName", browserName);
        caps.setCapability("browserVersion", browserVersion);
        sauceOptions.setCapability("name", "CookieTest with Windows 10 and chrome 87");
        caps.setCapability("extendedDebugging", "true");
        caps.setCapability("buildNumber", "1.0");
        caps.setCapability("sauce:options", sauceOptions);
        WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);

        //Go to the url
        driver.get(baseUrl);

        driver.getTitle();
        //Get the title and print it
//        System.out.println(driver.getTitle());

//        Set<Cookie> cookie = driver.manage().getCookies();
//        System.out.println("aleks is here getting cookies");
//        System.out.println(cookie);
//        for (int i = 0; i < cookie.size(); i++) {
//            System.out.println(cookie.getClass().getName());
//            System.out.println(cookie);
//        }
//        driver.get("https://www.google.com/");
        driver.get("http://localwebapp:8090");
        Cookie cookie1 = new Cookie("settingTheCookies", "s%3Aon-argHW2HF_WdrbBQbiPNhYCxtvHit7.yrTYT02ueyPLlve4gLeKK52n5Z7oPHq1TsRF%2BZzvwpQ", "google.com", "", null, false);
        driver.manage().addCookie(cookie1);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("window.localStorage.clear()");
        executor.executeScript("window.localStorage.setItem('accessToken', 'eyJraWQiOiIxalpyUENZaGV6alBsbUlqTDFcL3JYUjEzNmcxeUlNZnNRSDcyNENDVWM5cz0iLCJhbGciOiJSUzI1NiJ9.eyJhdF9oYXNoIjoiakZNbk13YldXZktxTUFXZHdsdU9SZyIsInN1YiI6IjQ4NjUxOGFhLTA3YTItNGJmNy04YTA2LTE0ZWNhMTA0ODM5MCIsImF1ZCI6IjZuNm40ZTR0N2szNDl0OWFzNzRpbDFlM3VoIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImV2ZW50X2lkIjoiMTI0ZmJhNjctYmMyOS00NWRmLWEwNmEtOTY4ZjAzMjBiOGE0IiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2MTE3MDAzMDksImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xXzY3eGd5ZE9nbSIsImNvZ25pdG86dXNlcm5hbWUiOiJYVFEzNDAiLCJleHAiOjE2MTE3MDM5MDksImlhdCI6MTYxMTcwMDMwOSwiZW1haWwiOiJ0ZXN0Mjk2QGRpc25leS5jb20ifQ.eLgCiwwnH2XhnxeMLgNaD49lw7LGTe0svc2g4RdEqY0iyxcdOYsCWJyjjzzYhR9nejOlBvIxIimquTlGMxOXcJDULpfqvMJ8KpCuP0fwHzmsbqymL_FL23QIaFfmkqvtUty-OUSZJaNOjE4v_3-p8xp4p24N0a95lKwWpHgSSOc0rRpX0k5bvJ8PpLrJud_aGuWRhctDaiUzQWUHjuvUlnuyfUkTZaNRDHTaggN_GQ0lO3nfD0uyJ5lhV1r_1Mm-iskgC7D52Kbt5_L5OoySh7pLORRYbl92XH0eyTkupH-oW0gK1l1EsEK9LA7h4wPABs-O1TpxNy3Z4kcLEieaug')");

        driver.quit();
    }
}