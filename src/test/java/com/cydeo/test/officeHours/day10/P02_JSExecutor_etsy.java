package com.cydeo.test.officeHours.day10;

import com.cydeo.test.utility.BrowserUtils;
import com.cydeo.test.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class P02_JSExecutor_etsy extends TestBase {
//    - Go to https://www.etsy.com
//            - Search for “wooden spoon”
//            - Click on filters
//		- Select free shipping  (use checkbox to click freeshipping. DON'T USE label tagged element to handle )
//            - Click apply filters
//            - Print count of results

    @Test
    public void etsyTask() {

        //1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        WebElement searchArea = driver.findElement(By.xpath("//input[@data-id=\"search-query\"]"));
        searchArea.sendKeys("wooden spoon" + Keys.ENTER);

        driver.findElement(By.xpath("//span[.=\"All Filters\"]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement free_shipping = driver.findElement(By.xpath("//label[@for=\"special-offers-free-shipping\"]"));

        js.executeScript("arguments[0].click()", free_shipping );
        driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]")).click();

        BrowserUtils.waitFor(3);
        String result = driver.findElement(By.xpath("//span[contains(text(),\"results,\")]")).getText();

        System.out.println(result);

    }

}
