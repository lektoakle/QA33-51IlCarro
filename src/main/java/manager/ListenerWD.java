package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.Random;

public class ListenerWD implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(WebDriverListener.class);

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElement(element, locator);
        logger.info("Before find element ->" + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("Before find element ->" + locator + " " + result.getTagName());
    }


    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        logger.info("sendKeys to element-> " + element.getTagName());
        logger.info("sendKeys keysToSend -> " + Arrays.toString(keysToSend));

    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info("Click on -> " + element.getTagName());
    }

    @Override
    public void beforeSubmit(WebElement element) {
        WebDriverListener.super.beforeSubmit(element);
        logger.info("Submit form -> " + element.getTagName() + element.getText());
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("Failed method:" + method.getName());
        logger.info("Arguments:" + Arrays.toString(args));
        logger.info("Exception:" + e.getTargetException().getClass().getSimpleName());
        logger.info("Message" + e.getTargetException().getMessage());
        int i = new Random().nextInt(1000) + 1000;
        String link = "src/test/screenshots/screen_" + i + ".png";
        logger.info("Screen with error is--->" + link);

        WebDriver wd = (ChromeDriver) target;
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
