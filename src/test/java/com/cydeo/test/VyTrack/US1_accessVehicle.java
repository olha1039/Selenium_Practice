package com.cydeo.test.VyTrack;

import com.cydeo.test.utility.Driver;
import com.cydeo.test.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1_accessVehicle {

    WebDriver driver;

    @Test
    public void AC1setUpMethod() {
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

//AC #1: Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
     /*
    Given the user navigate to the vytrack with the username user177, password UserUser123
Then the user will see Fleet Management page
When the user clicks fleet module
Then the user will see Vehicles sub-module
When the user clicks the Vehicles sub-module
Then the user will see the Cars header
And the user will see the Grid of all Vehicles
     */

    @Test
    public void AC2vehicleModule() {
        // 1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.

        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetModule.click();

        WebElement vehicleModule = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        vehicleModule.click();

        System.out.println(Driver.getDriver().getTitle());

    }













    //2 Verify that when user click on any car on the grid , system should display general information about the car
    /*
    Given the user is already on the Vehicles sub-module
    And the user sees the Cars header
    When the user clicks on any car on the grid
    Then the user will see the General Information on the selected car
     */
//    @Test
//    public void AC3generalInformation() {
//
//        WebElement car = driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action'])[1]"));
//        car.click();
//        WebElement generalInfo = driver.findElement(By.xpath("//span[.='General Information']"));
//
//    }

    // 3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well.
/*
Given the user is already on the page with the selected car
When the user clicks the Add Event button
And user fills out all information
And the user will click the Save button
Then the event will be displayed under Activity tab and General information
 */

//   // @Test
//    public void AC4addEvent() {
//        WebElement addEventBtn = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
//        addEventBtn.click();
//        System.out.println("addEventBtn.isDisplayed() = " + addEventBtn.isDisplayed());
//
//        WebElement titleTextBox = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_title-uid-62a0fa03d4bc8']"));
//        titleTextBox.sendKeys("group29");
//
//        WebElement ownerDropdown = driver.findElement(By.xpath("//button[@class='add-on btn entity-select-btn']"));
//        ownerDropdown.click();
//
//        WebElement name = driver.findElement(By.xpath("(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-username'])[1]"));
//        name.click();
//
//        WebElement organizerName = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_organizerDisplayName-uid-62a0fac81abe7']"));
//        organizerName.sendKeys("Saikal");
//
//        WebElement organizerEmail = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_organizerEmail-uid-62a0fac81acd7']"));
//        organizerEmail.sendKeys("saikal@cydeo.com");
//
//        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//        saveBtn.click();
//    }
//
//    @AfterMethod
//    public void teardownMethod() {
//        //  driver.close();
//    }
}
