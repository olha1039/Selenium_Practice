package com.cydeo.test.officeHours.day08;

import com.cydeo.test.utility.ConfigurationReader;
import com.cydeo.test.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class P01_WindowsOrTabs extends TestBase {
    @Test
    public void windowTest() throws InterruptedException {

        /*
        - Open "http://automationpractice.com/index.php"
			- Click twitter from Follow us
			- Switch to twitter tab
			- Verify title contains "Selenium Framework"
			- Switch to original tab
			- Verify title equals "My Store"
         */
        driver.get(ConfigurationReader.getProperty("windowsUrl"));

        // click twitter    css -- .twitter

        // current window handle
        String currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);

        WebElement twitter = driver.findElement(By.cssSelector(".twitter"));
        twitter.click();

        // current window handle
        currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);


        // get all window handles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(allHandles);

        System.out.println("======================");
        for (String each : allHandles) {
            System.out.println(each);
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().contains("twitter")){
                Thread.sleep(3000);
                System.out.println("Driver is here "+driver.getTitle());
                break;
            }
        }

        String expectedTitle = "Selenium Framework";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));


        System.out.println("SWITCH BACK TO MAIN PAGE ");
        driver.switchTo().window(currentWindow);

        expectedTitle = "My Store";
        Assert.assertEquals(driver.getTitle(),expectedTitle);



    }
}
