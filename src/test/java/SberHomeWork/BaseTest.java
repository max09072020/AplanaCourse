package SberHomeWork;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver mydriver;
    protected static String baseURL;
    public static Properties properties = TestProperties.getOnlyOne().getProperties();

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        mydriver = new ChromeDriver();
        baseURL = properties.getProperty("baseURL");
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mydriver.manage().window().maximize();
        mydriver.get(baseURL);

    }
    @AfterClass
    public static void wrapUp(){
        mydriver.quit();
    }

}
