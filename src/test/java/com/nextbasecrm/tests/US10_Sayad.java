package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US10_Sayad {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }


    @Test
    public void task1() {
        CRM_Utilities.crm_login(driver);

        // Users click the TASK tab
        WebElement taskTab = driver.findElement(By.xpath("(//span[.='Task'])[1]"));
        taskTab.click();
        BrowserUtils.sleep(3);

        // Users write task title and task content/message
        WebElement thingsToDo = driver.findElement(By.xpath("(//input[@placeholder='Things to do'])[1]"));
        BrowserUtils.sleep(3);
        thingsToDo.click();
        thingsToDo.sendKeys("Task has been created"+ Keys.ENTER);


        //   Users click the SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        BrowserUtils.sleep(3);

        //Verify the task is displayed on the feed
        WebElement result = driver.findElement(By.xpath("//div[@class='feed-create-task-popup-title']"));

        String expectedTitle = "Task has been created";
        String actualTitle = result.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
    @Test
    public void task2(){
        CRM_Utilities.crm_login(driver);

        // Users click the TASK tab
        WebElement taskTab = driver.findElement(By.xpath("(//span[@class='feed-add-post-form-link'])[1]"));
        taskTab.click();
        BrowserUtils.sleep(3);

       // Users write task title and task content/message
        WebElement thingsToDo = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        thingsToDo.sendKeys(""+ Keys.ENTER);

        // Users click the SEND button

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        BrowserUtils.sleep(3);
        sendButton.click();

        // Verify “The message title is not specified” warning message is displayed on the page
        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='task-message-label error']"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }
}
