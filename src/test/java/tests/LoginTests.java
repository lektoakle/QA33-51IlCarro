package tests;

import manager.HelperBase;
import org.openqa.selenium.By;
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
        }
    }

    @Test
    public void positiveLoginTest() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submitLoginForm();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }



    @Test
    public void negativeLoginWrongEmailTest() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("testemailtest.com", password);
        app.getHelperUser().submitLoginForm();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//div[@class='error']")));
//        there is no pop-up message in this test
    }

    @Test
    public void negativeLoginWrongPasswordTest() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, "aA@fdfdf");
        app.getHelperUser().submitLoginForm();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();
    }
    @AfterMethod
    public void postCondition() {
    }
}
