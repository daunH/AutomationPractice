package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageHalper.PageHelper;

public class LoginPage {
    private HomePage homePage = new HomePage();
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 4);
    private PageHelper pageHelper = new PageHelper();

    @FindBy(xpath = "//input[@name = 'user_login']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@name = 'user_pw']")
    private WebElement passwordField;

    @FindBy(xpath = "(//div[@class = 'input-row']/button)[1]")
    private WebElement logInButton;

    @FindBy(xpath = "(//div[@data-popup-handler = 'auth'])[1]")
    private WebElement personalCabinet;

    public void logIn(String email, String password) {
        personalCabinet.click();
        userEmailField.sendKeys(email);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public void waitForLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(pageHelper.getLoginForm()));

    }

}
