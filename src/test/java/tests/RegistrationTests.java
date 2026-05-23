package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationSuccess() {
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .setName("Anna")
                .setLastName("Snow")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("Snow123456$");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }

    @Test
    public void registrationEmptyName() {
        User user = new User()
                .setName("")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow123456$");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }

    @Test
    public void registrationEmptyLastName() {
        User user = new User()
                .setName("Lisa")
                .setLastName("")
                .setEmail("snow@gmail.com")
                .setPassword("Snow123456$");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }

    @Test
    public void registrationWrongEmail() {
        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snowgmail.com")
                .setPassword("Snow123456$");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //Assert.assertEquals(app.getHelperUser().getErrorText(),"Wrong email format \nWrong email format");
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }

    @Test
    public void registrationEmptyEmail() {
        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("")
                .setPassword("Snow123456$");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }

    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow123");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }

    @Test
    public void registrationEmptyPassword() {
        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("");
        logger.info("Testing data: " + user);

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());
    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}