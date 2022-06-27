package com.cydeo.test.officeHours.day08;

import com.cydeo.test.utility.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P03_TempMail extends TestBase {
    /*
            Step 1. Go to "https://www.fakemail.net/"
            Step 2. Copy and save email as a string.
            Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
            Step 4. And click on “Sign Up For Mailing List"
            Step 5. Enter any valid name.
            Step 6. Enter email from the Step 2.
            Step 7. Click Sign Up
            Step 8. Verify that following message is displayed:
            “Thank you for signing up. Click the button below to return to the home page.”
            Step 9. Navigate back to the “https://www.fakemail.net/”
            Step 10. Verify that you’ve received an email from -> “do-not-reply@practice.cydeo.com”
            Step 11. Click on that email to open it.
            Step 12. Verify that email is from: “do-not-reply@practice.cydeo.com”
            Step 13. Verify that subject is: “Thanks for subscribing to practice.cydeo.com!”
 */

        @Test
        public void tempMail() {
            //Step 1. Go to "https://www.fakemail.net/"
            driver.get("https://www.fakemail.net/");

            //Step 2. Copy and save email as a string.
            WebElement email = driver.findElement(By.id("email"));
            String emailStr = email.getText();

            //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
            driver.navigate().to("https://practice-cybertekschool.herokuapp.com");

            //Step 4. And click on “Sign Up For Mailing List"
            driver.findElement(By.linkText("Sign Up For Mailing List")).click();
            //driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']"));

            //Step 5. Enter any valid name.
            Faker faker = new Faker();
            driver.findElement(By.name("full_name")).sendKeys(faker.name().fullName());

            //Step 6. Enter email from the Step 2.
            driver.findElement(By.name("email")).sendKeys(emailStr);

            //Step 7. Click Sign Up
            driver.findElement(By.cssSelector(".radius")).click();

            //shortcut for steps 5-6-7
            //driver.findElement(By.name("full_name")).sendKeys(faker.name().fullName() + Keys.TAB + emailStr + Keys.TAB + Keys.ENTER);

            //Step 8. Verify that following message is displayed:
            //            “Thank you for signing up. Click the button below to return to the home page.”

            String actual = driver.findElement(By.xpath("//h3")).getText();
            Assert.assertEquals(actual, "Thank you for signing up. Click the button below to return to the home page.");

            //Step 9. Navigate back to the “https://www.fakemail.net/”
            driver.get("https://www.fakemail.net/");

            //Step 10. Verify that you’ve received an email from -> “do-not-reply@practice.cydeo.com”
            WebElement mail = driver.findElement(By.xpath("//tbody/tr[1]"));
            System.out.println("mail" + mail.getText());

            //Step 11. Click on that email to open it.
            mail.click();

            //Step 12. Verify that email is from: “do-not-reply@practice.cydeo.com”
            String mailFrom = driver.findElement(By.cssSelector("#odesilatel")).getText();
            System.out.println("mailFrom = " + mailFrom);
            Assert.assertTrue(mailFrom.equals("do-not-reply@practice.cydeo.com"), "The mail is not from cydeo");

            //Step 13. Verify that subject is: “Thanks for subscribing to practice.cydeo.com!”
            String subject = driver.findElement(By.cssSelector("#predmet")).getText();
            String expectedSubject = "Thanks for subscribing to practice.cydeo.com!";
            Assert.assertEquals(subject, expectedSubject, "The subject is as not expected");

        }
    }

