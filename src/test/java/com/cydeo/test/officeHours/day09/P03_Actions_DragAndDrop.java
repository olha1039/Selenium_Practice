package com.cydeo.test.officeHours.day09;

import com.cydeo.test.utility.BrowserUtils;
import com.cydeo.test.utility.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class P03_Actions_DragAndDrop {
//     - Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
//            - Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
//            - Verify Trash has 2 photo

    @Test
   public void dragAndDrop(){
        Driver.getDriver().get("https://www.globalsqa.com/demo-site/draganddrop/");
        Actions actions = new Actions(Driver.getDriver());

        WebElement iframe = Driver.getDriver().findElement(By.cssSelector(".demo-frame.lazyloaded"));
        Driver.getDriver().switchTo().frame(iframe);
        //Extra
        List <WebElement> elements = Driver.getDriver().findElements(By.xpath("//h5[contains(.,\"High\")]"));
        System.out.println(BrowserUtils.getElements(elements));
        System.out.println(BrowserUtils.getElementsTextWithStream(elements));

        WebElement first = Driver.getDriver().findElement(By.xpath("//h5[.=\"High Tatras\"]"));
        WebElement second = Driver.getDriver().findElement(By.xpath("//h5[.=\"High Tatras 2\"]"));
        WebElement trash = Driver.getDriver().findElement(By.cssSelector("#trash"));

        actions.dragAndDrop(first,trash).perform();
        actions.moveToElement(second).clickAndHold().moveToElement(trash).pause(3000).release().perform();

        BrowserUtils.waitFor(3);
        List<WebElement> trashElements = Driver.getDriver().findElements(By.xpath("//div[@id='trash']//li"));

        Assert.assertTrue(trashElements.size()==2);

    }





}
