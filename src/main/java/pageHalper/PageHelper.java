package pageHalper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageHelper {
    private Actions actions = new Actions(new ChromeDriver());

    @FindBy(xpath = "//h1[@class = 'page-header']")
    private WebElement searchResultsInscription;

    @FindBy(xpath = "//form[@data-popup = 'auth']")
    private WebElement loginForm;

    @FindBy(xpath = "//div[@class = 'bread-crumbs']")
    private WebElement breadCrumbs;

    @FindBy(xpath = "(//div[@class = 'simple-slider-list__link']/a)[36]")
    private WebElement lastFoundProduct;


    public WebElement getSearchResultsInscription() {
        return searchResultsInscription;
    }

    public WebElement getLoginForm() {
        return loginForm;
    }

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
