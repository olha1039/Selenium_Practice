package com.cydeo.test.VyTrack.US1;

import com.cydeo.test.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AC1_navigateToVehicle {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys("user177");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();

    }
    @AfterMethod
    public void teardownMethod() {
      //  driver.close();
    }

    @Test
    public void vehicleModule(){

        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetModule.click();

        WebElement vehicleModule = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        vehicleModule.click();

        WebElement car = driver.findElement(By.xpath("//td[.='SDET']"));
        car.click();

        WebElement generalInfo = driver.findElement(By.xpath("//span[.='General Information']"));
        System.out.println("generalInfo.isDisplayed() = " + generalInfo.isDisplayed());


        WebElement addEventBtn = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));




    }






}
