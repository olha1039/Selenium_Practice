package com.cydeo.test.officeHours.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_LinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");


        WebElement multiple_buttons = driver.findElement(By.linkText("Multiple Buttons")); // .click() can do as well,as a chaining
        multiple_buttons.click();

        Thread.sleep(3000);

        String expectedTitle = "Multiple Buttons";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED");
        }

        driver.navigate().back();
        Thread.sleep(2000);

        actualTitle = driver.getTitle();
        expectedTitle = "Practice";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // driver.close(); // closes only current tab
        driver.quit(); // it wil close all tabs into current browser
    }
}
