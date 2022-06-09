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

    @Test
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
    public void vehicleModule() {
        // 1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.

        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetModule.click();

        WebElement vehicleModule = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        vehicleModule.click();
    }

    //2 Verify that when user click on any car on the grid , system should display general information about the car

    @Test
    public void generalInformation() {

        WebElement car = driver.findElement(By.xpath("//td[.='SDET']"));
        car.click();

        WebElement generalInfo = driver.findElement(By.xpath("//span[.='General Information']"));

     //   System.out.println("generalInfo.isDisplayed() = " + generalInfo.isDisplayed());
    }

    // 3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well.

 //   @Test
    public void addEvent() {
        WebElement addEventBtn = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
        addEventBtn.click();
        System.out.println("addEventBtn.isDisplayed() = " + addEventBtn.isDisplayed());

        WebElement titleTextBox = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_title-uid-62a0fa03d4bc8']"));
        titleTextBox.sendKeys("group29");

        WebElement ownerDropdown = driver.findElement(By.xpath("//button[@class='add-on btn entity-select-btn']"));
        ownerDropdown.click();

        WebElement name = driver.findElement(By.xpath("(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-username'])[1]"));
        name.click();

        WebElement organizerName = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_organizerDisplayName-uid-62a0fac81abe7']"));
        organizerName.sendKeys("Saikal");

        WebElement organizerEmail = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_organizerEmail-uid-62a0fac81acd7']"));
        organizerEmail.sendKeys("saikal@cydeo.com");

        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        saveBtn.click();
    }


}
