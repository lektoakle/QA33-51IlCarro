package tests;

import org.testng.annotations.Test;



public class LoginTests extends TestBase {

    String email = "testemail@test.com";
    String password = "aA1@fdfdf";

    @Test
    public void positiveTest(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submitLoginForm();
        app.getHelperUser().checkLoggedIn();


    }
}
