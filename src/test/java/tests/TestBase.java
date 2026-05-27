package tests;

import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void setLogger(Method m) {
        logger.info("Name of method: " + m.getName());
    }


    @AfterMethod
    public void end() {
        logger.info("=================================");
    }

    @AfterMethod
    public void tearDown() {
        app.stop();

    }
}

