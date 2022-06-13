package com.cydeo.test.CRM;

import com.cydeo.test.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_US2 extends TestBase{

    // Description:  Users send text messages successfully
//1.  Users are on the homepage (Login with valid username and password)
//2.  Users click the MESSAGE tab
//3.  Users write test message
//4.  Users click the SEND button
//5.  Verify the message is displayed on the feed


    @Test
    public void sendText(){
        driver.get("https://login2.nextbasecrm.com/");

//        3- Login Homepage ( Login with valid username and password)

        CRMLoginUtil.crm_login(driver, "helpdesk57@cybertekschool.com", "UserUser");
//        4- Click the MORE tab and select APPRECIATION

        WebElement moreBtn = driver.findElement(By.cssSelector("span[id*='link-text']")); //xpath "//span[contains(@id,'link-text-)]"
        moreBtn.click();

//        5- Write an Appreciation message

        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

//        6- Click the SEND button

        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Hello from the other side!");

        // if you have nested frame going one frame up will be parent frame, otherwise default is main html frame

        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

//        7- Verify the Appreciation message is displayed on the feed

        WebElement feedText = driver.findElement(By.xpath("//div[starts-with(@id, 'blog_post_body')]"));
        String actualText = feedText.getText();
        String expectedText = "Hello from the other side!";
        Assert.assertEquals(actualText,expectedText,"Feed message did not appear correctly!");




    }
    }



