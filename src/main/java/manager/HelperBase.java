package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String data) {
        WebElement field = wd.findElement(locator);
        field.click();
        clearNew(field);
        field.sendKeys(data);
    }

    public void clearNew(WebElement element){
        String os = System.getProperty("os.name");
        System.out.println(os);


        element.sendKeys(" ");
//        element.sendKeys(Keys.BACK_SPACE);

        if(os.startsWith("Win")||os.startsWith("Lin")){
            element.sendKeys(Keys.CONTROL,"a");
        }else {
            element.sendKeys(Keys.COMMAND,"a");
        }
        element.sendKeys(Keys.DELETE);
    }

    public void click(By locator) {
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        return !list.isEmpty();
    }

    public String getErrorText(){
        return wd.findElement(By.cssSelector("div.error")).getText();
    }
}

