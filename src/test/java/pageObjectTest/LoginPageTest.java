package pageObjectTest;


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


    @Before
    public void precondition() {
        basePageTest.openSite();
        loginPage = PageFactory.initElements(basePageTest.getWebDriver(), LoginPage.class);
        pageHelper = PageFactory.initElements(basePageTest.getWebDriver(), PageHelper.class);

    }

    @Test
    public void verifyInabilityToLogInWithInvalidEmail() {
        loginPage.logIn("invalid@gmail.com", "validpass1");
        Assert.assertTrue("User logged in", PageHelper.loginForm.isDisplayed());
    }


}

