package tests;

import manager.DataProviderUser;
import models.User;
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

    @Test(dataProvider = "positiveLoginData", dataProviderClass = DataProviderUser.class)
    public void positiveLoginTest(User user) {
        app.getHelperUser().openLoginForm();
        logger.info("Testing data: " + user.getEmail() + ", " + user.getPassword());
        app.getHelperUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }


    @Test(dataProvider = "negativeLoginWrongEmailData", dataProviderClass = DataProviderUser.class)
    public void negativeLoginWrongEmailTest(User user) {

//        app.getHelperUser().fillLoginForm("testemailtest.com", password);

//        logger.info("Testing data: " + "testemailtest.com" + ", " + password);


        app.getHelperUser().openLoginForm();
        logger.info("Testing data: " + user.getEmail() + ", " + user.getPassword());
        app.getHelperUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());

    }

    @Test(dataProvider = "negativeLoginWrongPasswordData", dataProviderClass = DataProviderUser.class)
    public void negativeLoginWrongPasswordTest(User user) {

        app.getHelperUser().openLoginForm();
        logger.info("Testing data: " + user.getEmail() + ", " + user.getPassword());
        app.getHelperUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getHelperUser().submit();
//        app.getHelperUser().fillLoginForm(email, "aA@fdfdf");
//        logger.info("Testing data: " + email + ", " + "aA@fdfdf");


        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
