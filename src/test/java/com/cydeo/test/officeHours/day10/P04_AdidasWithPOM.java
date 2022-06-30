package com.cydeo.test.officeHours.day10;

import com.cydeo.test.pages.AdidasPage;
import com.cydeo.test.utility.BrowserUtils;
import com.cydeo.test.utility.ConfigurationReader;
import com.cydeo.test.utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class P04_AdidasWithPOM {

//    SHOP: https://www.demoblaze.com/index.html
//            • Customer navigation through product categories: Phones, Laptops and Monitors
//	• Navigate to "Laptops" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
//            • Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
//            • Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
//            • Navigate to "Cart" → Delete "Apple monitor 24" from cart.
//            • Click on "Place order".
//            • Fill in all web form fields.
//            • Click on "Purchase"
//            • Capture and log purchase Id and Amount.
//	• Assert purchase amount equals expected.
//	• Click on "Ok"
//            • Verify that there is no product in the cart
//    NOTE : We will create Page Object Model (POM) to solve this task


    @Test
    public void adidas(){

        Driver.getDriver().get(ConfigurationReader.getProperty("adidasUrl"));
        AdidasPage adidasPage = new AdidasPage();

        int expectedPrice = adidasPage.addProduct("Laptops", "Sony vaio i5");
        expectedPrice += adidasPage.addProduct("Phones", "Samsung galaxy s6");
        expectedPrice += adidasPage.addProduct("Monitors", "Apple monitor 24");



        System.out.println(expectedPrice);

        adidasPage.cart.click();
        BrowserUtils.waitFor(1);

        expectedPrice -= adidasPage.removeProduct("Apple monitor 24");
        System.out.println("After delete product");

        System.out.println(expectedPrice);

        adidasPage.placeOrder.click();

        adidasPage.fillForm();

        adidasPage.purchaseButton.click();
        BrowserUtils.waitFor(2);

        Driver.closeDriver();

    }



}
