package utilities.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.base.BaseTest;

import java.util.concurrent.TimeUnit;

public class Browser {

    private final Logger logger = Logger.getLogger(Browser.class);
    private static Configuration config = Configuration.getInstance();
    private DesiredCapabilities capabilities;


    private void chromeOptions(){
        ChromeOptions options = new ChromeOptions();



        capabilities = DesiredCapabilities.chrome();

        options.addArguments("--test-type");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("useAutomationExtension", true);

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName(options.getBrowserName().toUpperCase());
        capabilities.setVersion(System.getProperty("os.version"));
        capabilities.setPlatform(Platform.getCurrent());
        capabilities.setCapability("acceptSslCerts", "true");
    }

    private void commonMethod(){
        BaseTest.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        if (capabilities.getPlatform().toString().equals("MAC")){
            BaseTest.getDriver().manage().window().setSize(new Dimension(1280, 900));
        }else {
            BaseTest.getDriver().manage().window().maximize();
        }


            logger.info("Test Environment : Local");


        logger.info("Installation Complete");
        logger.info("********* BROWSER:" + capabilities.getBrowserName() + ", " + "VERSION:" + capabilities.getVersion()
                + ", " + "PLATFORM:" + capabilities.getPlatform());
    }


    public void createLocalDriver(){
        chromeOptions();
        selectPath(capabilities.getPlatform());
        BaseTest.setDriver(new ChromeDriver(capabilities));
        commonMethod();
    }

    private void selectPath(Platform platform) {
        String browser;
        if ("CHROME".equalsIgnoreCase(capabilities.getBrowserName())) {
            browser = "webdriver.chrome.driver";

                    System.setProperty(browser, "properties/driver/chromedriver.exe");

        }
    }
}
