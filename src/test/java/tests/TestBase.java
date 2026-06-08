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

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        app.init();
    }

    public void setLogger(Method m) {
        logger.info("Name of method: " + m.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void end() {
        logger.info("=================================");
    }

    public void tearDown() {
        app.stop();

    }
}

