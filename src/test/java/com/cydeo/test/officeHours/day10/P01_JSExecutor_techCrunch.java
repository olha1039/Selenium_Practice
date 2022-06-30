package com.cydeo.test.officeHours.day10;

import com.cydeo.test.utility.BrowserUtils;
import com.cydeo.test.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_JSExecutor_techCrunch {

//      - Go to  "https://techcrunch.com/"
//            - Click TechCrunch from Footer > About > TechCrunch
//       - Verify title contains "TechCrunch"

    @Test
    public void test() {
        Driver.getDriver().get("https://techcrunch.com/");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("window.scrollBy(0,7500)");

        WebElement techCrunch = Driver.getDriver().findElement(By.xpath("//a[@data-ga-event-label=\"TechCrunch\"]"));

        js.executeScript("arguments[0].scrollIntoView(true)", techCrunch);
        BrowserUtils.waitFor(3);
        techCrunch.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("TechCrunch"));


    }
}
