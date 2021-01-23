package pageObjectTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BasePageTest {
    private static final String baseUrl = "https://makeup.com.ua/";
    private WebDriver webDriver;
    private Actions actions = new Actions(webDriver);

    private void initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/ProjectTest/src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public void openSite() {
        initializeChromeDriver();
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void closeChrome() {
        webDriver.close();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


}
