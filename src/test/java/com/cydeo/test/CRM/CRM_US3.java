package com.cydeo.test.CRM;

import com.cydeo.test.utility.ConfigurationReader;
import com.cydeo.test.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_US3 {

    @Test
    public void US3_AC1_Search() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        WebElement searchBox = Driver.getDriver().findElement(By.id("search-textbox-input"));
        searchBox.sendKeys("Chuck Norris" + Keys.ENTER);

        WebElement searchText = Driver.getDriver().findElement(By.id("LIVEFEED_search"));

        String actualActivityStreamText = searchText.getAttribute("value");
        Assert.assertEquals(actualActivityStreamText,"Chuck Norris");

    }
}
