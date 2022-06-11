package com.cydeo.test.demoTests;

import com.cydeo.test.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MoneyGaming {
    /*
       1. Navigate to: https://moneygaming.qa.gameaccount.com/
        2. Click the JOIN NOW button to open the registration page +
        3. Select a title value from the dropdown +
        4. Enter your first name and surname in the form +
        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        6. Submit the form by clicking the JOIN NOW button
        7. Validate that a validation message with text "This field is required" appears under the date of birth box
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://moneygaming.qa.gameaccount.com/");
    }

    @Test
    public void test(){
        WebElement joinBtn = driver.findElement(By.xpath("//a[@class='newUser green']"));
        joinBtn.click();

        Select titleDropdown = new Select(driver.findElement(By.cssSelector("#title")));
        titleDropdown.selectByVisibleText("Ms");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='map(firstName)']"));
        firstName.sendKeys("Olha");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        lastName.sendKeys("Diachkova");

        WebElement termsBox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
        termsBox.click();

        WebElement submitBtn = driver.findElement(By.id("form"));
        submitBtn.click();

        WebElement messageText = driver.findElement(By.xpath("//label[@for='dob']"));
        String actual = messageText.getText();
        String expected = "This field is required";
        Assert.assertEquals(actual, expected, "Failed!");

    }


}