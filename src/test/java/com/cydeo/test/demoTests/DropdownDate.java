package com.cydeo.test.demoTests;

import com.cydeo.test.utility.WebDriverFactory;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownDate {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void selectDropdownTest() {
        Select yearDropdown = new
                Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new
                Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new
                Select(driver.findElement(By.xpath("//select[@id='day']")));

        yearDropdown.selectByVisibleText("1923");

        monthDropdown.selectByValue("11");

        dayDropdown.selectByIndex(0);
//creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";
//getting actual values from browser
        String actualYear =
                yearDropdown.getFirstSelectedOption().getText();
        String actualMonth =
                monthDropdown.getFirstSelectedOption().getText();
        String actualDay =
                dayDropdown.getFirstSelectedOption().getText();
//create assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);
    }

    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }


}





