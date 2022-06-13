package com.cydeo.test.CRM;

import com.cydeo.test.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CRM_US2 extends TestBase {

    // Given user successfully logged into CRM page
    // When user clicks on message button
    // And user types message in the message console
    // And user clicks send button
    // The message should be displayed in the feed
    @Test
    public void AC1sendText() {
        driver.get("https://login2.nextbasecrm.com/");
        CRMLoginUtil.crm_login(driver, "marketing57@cybertekschool.com", "UserUser");
        WebElement messageBtn = driver.findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Test");
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

        WebElement feedText = driver.findElement(By.xpath("//div[starts-with(@id, 'blog_post_body')]"));
        String actualText = feedText.getText();
        String expectedText = "Test";
        Assert.assertEquals(actualText, expectedText, "Feed message did not appear correctly!");
    }

    // Given user successfully logged into CRM page
    // When user clicks on message button
    // And user types in message console
    // And user clicks on cancel button
    // Then message console collapsed and message canceled
    @Test
    public void AC2CancelMessage() {
        driver.get("https://login2.nextbasecrm.com/");
        CRMLoginUtil.crm_login(driver, "marketing57@cybertekschool.com", "UserUser");
        WebElement messageBtn = driver.findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Test");
        driver.switchTo().defaultContent();
        WebElement cancelBtn = driver.findElement(By.id("blog-submit-button-cancel"));
        cancelBtn.click();
    }

    // Given user successfully logged into CRM page
    // When user clicks on message button
    // And user click link button
    // And user adds link to the popup window
    // And user click save
    // Then link should be added to text message
 //   @Test
    public void AC3attachLink(){
        driver.get("https://login2.nextbasecrm.com/");
        CRMLoginUtil.crm_login(driver, "marketing57@cybertekschool.com", "UserUser");
        WebElement messageBtn = driver.findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
       // driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        WebElement linkBtn = driver.findElement(By.cssSelector("//div[@id='post-buttons-bottom']//span[@title='Link']"));
        linkBtn.click();
    }





 //   @AfterMethod
    public void tearDown() {
        driver.close();
    }

}



