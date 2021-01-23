package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageHalper.PageHelper;

import java.util.List;

public class HomePage {

    private WebDriver driver = new ChromeDriver();
    private PageHelper pageHelper = new PageHelper();
    private WebDriverWait wait = new WebDriverWait(driver, 4);

    @FindBy(xpath = "//input[@id = 'search-input']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class = 'menu-list__link']")
    private List<WebElement> menuList;


    @FindBy(xpath = "//li[@class = 'menu-column-list__item']/a")
    private List<WebElement> valuesProductCategory;

    @FindBy(xpath = "(//button[@type = 'submit'])[1]")
    private WebElement submitButton;

    @FindBy(css = "div.slide>a")
    List<WebElement> slides;

    @FindBy(css = "button.slider-arrow-next")
    private WebElement arrowSlider;

    public WebElement getSubmitButton() {
        return submitButton;
    }


    public void searchProduct(String productName) {
        searchField.sendKeys(productName);
    }

    public void selectProductCategoryFromMenu(String menuOption) {
        for (WebElement menuItemW : menuList) {
            String menuItemS = menuItemW.getText();
            if (menuOption.equals(menuItemS)) {
                pageHelper.getActions().moveToElement(menuItemW);
                pageHelper.getActions().perform();
            }
        }
    }

    public void selectProductFromCategory(String dropDownValue) {
        for (WebElement dropDownOptionW : valuesProductCategory) {
            String dropDownOptionS = dropDownOptionW.getText();
            if (dropDownValue.equals(dropDownOptionS)) {
                dropDownOptionW.click();
            }
        }
    }


    public void waitingForProducts() {
        wait.until(ExpectedConditions.visibilityOf(pageHelper.getLastFoundProduct()));
    }

    public void waitingForBreadCrumbs() {
        wait.until(ExpectedConditions.visibilityOf(pageHelper.getBreadCrumbs()));
    }


}
