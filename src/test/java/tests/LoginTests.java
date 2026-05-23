package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    String email = "testemail@test.com";
    String password = "aA1@fdfdf";

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("logging out");
        }
    }

    @Test
    public void positiveLoginTest() {
        app.getHelperUser().openLoginForm();
        logger.info("Testing data: " + email +", " + password);
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }


    @Test
    public void negativeLoginWrongEmailTest() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("testemailtest.com", password);

        logger.info("Testing data: " + "testemailtest.com" +", " + password);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());

    }

    @Test
    public void negativeLoginWrongPasswordTest() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, "aA@fdfdf");
        logger.info("Testing data: " + email +", " + "aA@fdfdf");

        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
