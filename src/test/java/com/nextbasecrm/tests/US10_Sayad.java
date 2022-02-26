package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Username_Password;
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
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //String userName = "marketing15@cydeo.com";
        //String password = "UserUser";

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

        //driver.findElement(By.xpath("//input[@name='USER_LOGIN'")).sendKeys(userName);
        //driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

    @Test
    public void task1()  {
        Username_Password.username3(driver);

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
        BrowserUtils.sleep(3);

        // Users click the TASK tab
        WebElement taskTab = driver.findElement(By.xpath("(//span[.='Task'])[1]"));
        taskTab.click();

        //   Users write task title and task content/message
        WebElement thingsToDo = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        thingsToDo.sendKeys("Task has been created"+ Keys.ENTER);

        //   Users click the SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // Verify the task is displayed on the feed
        WebElement taskDisplayed = driver.findElement(By.xpath("//div[@class='feed-create-task-popup-title']"));
        System.out.println("taskDisplayed.isDisplayed() = " + taskDisplayed.isDisplayed());
    }
    @Test
    public void task2(){

        Username_Password.username3(driver);

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        BrowserUtils.sleep(3);

        // Users click the TASK tab
        WebElement taskTab = driver.findElement(By.xpath("(//span[@class='feed-add-post-form-link'])[1]"));
        taskTab.click();

        // Users write task title and task content/message
        WebElement thingsToDo = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        thingsToDo.sendKeys(""+ Keys.ENTER);

        // Users click the SEND button
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // Verify “The message title is not specified” warning message is displayed on the page
        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='task-message-label error']"));
        System.out.println("warningMessage.isDisplayed() = " + warningMessage.isDisplayed());
    }
}
