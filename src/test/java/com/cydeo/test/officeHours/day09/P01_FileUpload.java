package com.cydeo.test.officeHours.day09;

import com.cydeo.test.utility.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_FileUpload {
//    - Go to  "https://testpages.herokuapp.com/styled/file-upload-test.html"
//            - Upload file into Choose File
//    NOTE : Create a file called as UploadTest.txt in project to upload ( I will show how we can )
//       - Choose General File
//       - Click Upload button
//       - Verify Expected message equals "You uploaded a file. This is the result."

    @Test
    public void fileUpload(){
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        String filePath = "C:\\Users\\olga-\\OneDrive\\Desktop\\Uploadfile.txt.txt";
        WebElement chooseFile = Driver.getDriver().findElement(By.id("fileinput"));
        chooseFile.sendKeys(filePath);

        WebElement radioBtn = Driver.getDriver().findElement(By.id("itsafile"));
        radioBtn.click();

        WebElement uploadBtn = Driver.getDriver().findElement(By.name("upload"));
        uploadBtn.click();

        WebElement textResult = Driver.getDriver().findElement(By.className("explanation"));
        Assert.assertEquals(textResult.getText(), "You uploaded a file. This is the result.");
    }





}
