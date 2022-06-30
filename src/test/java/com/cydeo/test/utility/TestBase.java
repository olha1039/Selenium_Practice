package com.cydeo.test.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup(){
       // driver = WebDriverFactory.getDriver("chrome"); // without singleton
        driver = Driver.getDriver(); // in order to use singleton approach
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

    }
}
