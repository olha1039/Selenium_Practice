package com.cydeo.test.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){
    }

    // close access from outside the class, static because we will use it inside static method
    private static WebDriver driver;


    public static WebDriver getDriver(){

        // checks if driver is null - will set up browser inside if statement, if it is set up (not null), it will return the same driver
        if(driver == null){

            // reading BrowserType from configuration.properties and ConfigurationReader class
            String browserType = ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // terminate the existing driver session, making sure driver is null after quit.
            driver.quit();
            driver = null;
        }
    }
}
