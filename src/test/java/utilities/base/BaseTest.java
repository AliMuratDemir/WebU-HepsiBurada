package utilities.base;




import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.helper.Browser;
import utilities.helper.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    protected static WebDriver driver;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private static Configuration config = Configuration.getInstance();

    private static Browser browser = new Browser();

    @BeforeScenario
    public void setUp() throws Exception {
   //     Utils.startRecording("deneme");
        PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start!");


            /** LOCAL ENV **/
            browser.createLocalDriver();


    }

    @AfterScenario
    public void tearDown() throws Exception {

        System.out.println("SESSIONID:  " + ((RemoteWebDriver) driver).getSessionId());


        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);

     //   Utils.stopRecording();



        //getDriver().quit();
       // log.info("Driver close");
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(RemoteWebDriver driver) {
        BaseTest.driver = driver;
    }

}