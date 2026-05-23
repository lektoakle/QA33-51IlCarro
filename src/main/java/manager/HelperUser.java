package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));


    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);


    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));


    }

//    public void checkLoggedIn() {
//
//        WebElement signOutButton = wd.findElement(By.xpath("//a[text()=' Logout ']"));
//
//    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        // pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public void clickOkButton() {
        By locator = By.xpath("//button[text()='Ok']");
        if (isElementPresent(locator))
            click(locator);
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public boolean isYallaButtonDisabled() {
        // return isElementPresent(By.xpath("//button[@disabled]"));
        return !wd.findElement(By.xpath("//button[@disabled]")).isEnabled();
    }

//    Registration


    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy() {
        //var1
        // click(By.id("terms-of-use"));

        //var2
        //click(By.cssSelector("label[for='terms-of-use']"));

        //var3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicyXY() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rectangle = label.getRect();
            int w = rectangle.getWidth();

            //Dimension size = wd.manage().window().getSize();

            int xOffset = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffset, 0).click().release().perform();
        }
    }
}
