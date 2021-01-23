package pageHalper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageHelper {
    private Actions actions = new Actions(new ChromeDriver());
    @FindBy(css = "a[data-default-name]")
    public static WebElement randomProduct;

    @FindBy(xpath = "//form[@data-popup = 'auth']")
    public static WebElement loginForm;

    @FindBy(xpath = "//li[@itemprop = 'itemListElement']/span")
    public static WebElement breadCrumbs;

    @FindBy(xpath = "(//div[@class = 'simple-slider-list__link']/a)[36]")
    private WebElement lastFoundProduct;

    public Actions getActions() {
        return actions;
    }

    public WebElement getBreadCrumbs() {
        return breadCrumbs;
    }

    public WebElement getLastFoundProduct() {
        return lastFoundProduct;
    }
}
