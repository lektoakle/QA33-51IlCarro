package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
       click(By.xpath("//a[text()=' Log in ']"));


    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);


    }

    public void submitLoginForm() {
        click(By.xpath("//button[@type='submit']"));


    }

    public void checkLoggedIn() {

        WebElement signOutButton = wd.findElement(By.xpath("//a[text()=' Logout ']"));

    }
}
