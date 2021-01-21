package pageObjectTest;

import PageObject.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageHalper.PageHelper;

public class HomePageTest {
    private BasePageTest basePageTest = new BasePageTest();
    private HomePage homePage;
    private PageHelper pageHelper;


    @Before
    public void precondition() {
        basePageTest.openSite();
        homePage = PageFactory.initElements(basePageTest.getWebDriver(), HomePage.class);
        pageHelper = PageFactory.initElements(basePageTest.getWebDriver(), PageHelper.class);
    }

    @After
    public void closeChrome() {
        basePageTest.closeChrome();
    }


    @Test
    public void verifySearchField() {
        homePage.searchProduct("lipstick");
        homePage.getSubmitButton().submit();
        Assert.assertTrue(pageHelper.getSearchResultsInscription().isDisplayed());
    }

    @Test
    public void verifyAbilityToSelectFromDropDown() {
        homePage.selectProductCategoryFromMenu("Парфюмерия");
        homePage.selectProductFromCategory("Наборы");
        Assert.assertTrue(pageHelper.getBreadCrumbs().isDisplayed());
    }

    @Test
    public void verifyAbilityToSwitchSlides() {
        int amountOfSlides = homePage.switchSlides();
        Assert.assertTrue(amountOfSlides == 6);

    }

}
