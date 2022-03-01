package com.nextbasecrm.tests.US13_Elbek;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Username_Password;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory13 {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @Test
    public void test1(){

    // Log In

        // start
        Username_Password.username1(driver);
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        // finish

    // Switch to appreciation tab

        // start
        WebElement more = driver.findElement(By.xpath("//span[.='More']"));
        more.click();
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();
        // finish

    // Send a message

        // start
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//body[@style='min-height: 184px;']"));
        textBox.click();
        textBox.sendKeys("Something2");
        driver.switchTo().defaultContent();
        WebElement send = driver.findElement(By.id("blog-submit-button-save"));
        send.click();
        // finish

    // Check if the message is sent

        // start
        /*
        WebElement check = driver.findElement(By.id("blog_post_body_6437"));
        Assert.assertEquals(check.getText(), "Something1");
         */
        // finish

// Empty message sending

    // Switch to appreciation tab

        // start
        /*
        more.click();
        appreciation.click();
         */
        // finish

    // Send an empty message and check for the alert message

        // start
        send.click();
        WebElement alert = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        Assert.assertEquals(alert.getText(), "The message title is not specified");
        // finish

    }

    @Test
    public void test2(){

    // Log In

        // start
        Username_Password.username2(driver);
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        // finish

    // Switch to appreciation tab

        // start
        WebElement more = driver.findElement(By.xpath("//span[.='More']"));
        more.click();
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();
        // finish

    // Send a message

        // start
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//body[@style='min-height: 184px;']"));
        textBox.click();
        textBox.sendKeys("Something2");
        driver.switchTo().defaultContent();
        WebElement send = driver.findElement(By.id("blog-submit-button-save"));
        send.click();
        // finish

    // Check if the message is sent

        // start
        /*
        WebElement check = driver.findElement(By.id("blog_post_body_6437"));
        Assert.assertEquals(check.getText(), "Something1");
         */
        // finish

// Empty message sending

    // Switch to appreciation tab

        // start
        /*
        more.click();
        appreciation.click();
         */
        // finish

    // Send an empty message and check for the alert message

        // start
        send.click();
        WebElement alert = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        Assert.assertEquals(alert.getText(), "The message title is not specified");
        // finish

    }

    @Test
    public void test3(){

    // Log In

        // start
        Username_Password.username3(driver);
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        // finish

    // Switch to appreciation tab

        // start
        WebElement more = driver.findElement(By.xpath("//span[.='More']"));
        more.click();
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();
        // finish

    // Send a message

        // start
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//body[@style='min-height: 184px;']"));
        textBox.click();
        textBox.sendKeys("Something2");
        driver.switchTo().defaultContent();
        WebElement send = driver.findElement(By.id("blog-submit-button-save"));
        send.click();
        // finish

    // Check if the message is sent

        // start
        /*
        WebElement check = driver.findElement(By.id("blog_post_body_6437"));
        Assert.assertEquals(check.getText(), "Something1");
         */
        // finish

// Empty message sending

    // Switch to appreciation tab

        // start
        /*
        more.click();
        appreciation.click();
         */
        // finish

    // Send an empty message and check for the alert message

        // start
        send.click();
        WebElement alert = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        Assert.assertEquals(alert.getText(), "The message title is not specified");
        // finish

    }




}
