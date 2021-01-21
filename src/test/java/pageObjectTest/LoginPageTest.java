package pageObjectTest;

import PageObject.HomePage;
import PageObject.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageHalper.PageHelper;

public class LoginPageTest {

    private BasePageTest basePageTest = new BasePageTest();
    private LoginPage loginPage;
    private PageHelper pageHelper;
    private HomePage homePage;


    @Before
    public void precondition() {
        basePageTest.openSite();
        loginPage = PageFactory.initElements(basePageTest.getWebDriver(), LoginPage.class);
        pageHelper = PageFactory.initElements(basePageTest.getWebDriver(), PageHelper.class);
        homePage = PageFactory.initElements(basePageTest.getWebDriver(), HomePage.class);
    }

    @Test
    public void verifyInabilityToLogInWithIncorrectData() {
        loginPage.logIn("smmkvml", "12r12e12");
        Assert.assertTrue("User not logged in", pageHelper.getLoginForm().isDisplayed());
    }


}
