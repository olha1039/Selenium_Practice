package com.cydeo.test.officeHours.day09;

import com.cydeo.test.utility.ConfigurationReader;
import com.cydeo.test.utility.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_Actions_Dresses {
//    Task 1
//
//            - Go to  "http://automationpractice.com/index.php"
//            - Hover over on Dresses button
//       - Verify following subCategories are displayed
//
//    Casual Dresses
//    Evening Dresses
//    Summer Dresses

    @Test
    public void verifySubCategories() {
        Driver.getDriver().get(ConfigurationReader.getProperty("windowsUrl"));

        WebElement dressesBtn = Driver.getDriver().findElement(By.xpath("(//a[text()='Dresses'])[2]"));
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(dressesBtn).perform();

        WebElement casualDresses=Driver.getDriver().findElement(By.xpath("(//a[@title='Casual Dresses'])[2]"));
        Assert.assertTrue(casualDresses.isDisplayed());
        //  Evening Dresses
        WebElement eveningDresses=Driver.getDriver().findElement(By.xpath("(//a[@title='Evening Dresses'])[2]"));
        Assert.assertTrue(eveningDresses.isDisplayed());
        // Summer Dresses
        WebElement summerDresses=Driver.getDriver().findElement(By.xpath("(//a[@title='Summer Dresses'])[2]"));
        Assert.assertTrue(summerDresses.isDisplayed());
    }


}
