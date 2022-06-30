package com.cydeo.test.officeHours.day09;

import com.cydeo.test.utility.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class P04_Actions_login {

//    	   - Go to  "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx"
//            - Fill form with following information
//    fullname : TEST
//    email    : TEST
//	   - Click Login Button
//	   - Verify error message equals "Invalid Login or Password."


    @Test
    public void test() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement username = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_username"));
        WebElement password = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.name("ctl00$MainContent$login_button"));


        Actions actions = new Actions(Driver.getDriver());

        actions.click(username).keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).perform();
        actions.click(password).keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).perform();
        loginBtn.click();

        Assert.assertEquals(Driver.getDriver().findElement(By.id("ctl00_MainContent_status")).getText(), "Invalid Login or Password.");
    }


}
