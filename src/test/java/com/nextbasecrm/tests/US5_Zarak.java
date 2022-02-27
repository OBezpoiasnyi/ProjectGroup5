package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nextbasecrm.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class US5_Zarak {

    //------ TC/US# 5 [ Enter code below: ]

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void enterMessage() throws InterruptedException {
        driver.get("https://login1.nextbasecrm.com");

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement messageTab = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-message\"]/span"));
        messageTab.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement contextMessage = driver.findElement(By.xpath("/html/body[@contenteditable='true']"));
        contextMessage.sendKeys("test");

        driver.switchTo().parentFrame();

        WebElement submitKey = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        //submitKey.click();

        Thread.sleep(350);
        driver.close();
    }

    @Test
   public void messageWithoutContentErrorMessage() throws InterruptedException {

        driver.get("https://login1.nextbasecrm.com");

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement messageTab = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-message\"]/span"));
        messageTab.click();

        WebElement submitKey = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        submitKey.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-notice-blockblogPostForm\"]/div/span[2]"));


        String expectedErrorMessage = "The message title is not specified";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        Thread.sleep(250);
        driver.close();


    }


    }



