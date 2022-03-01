package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US14Cameron {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        driver.findElement(By.name("USER_LOGIN")).sendKeys(ConfigurationReader.getProperty("username1"));
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);

    }
    @Test
    public void test(){
        // Scroll down to Desktop client sidebar
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");


         WebElement Mac= driver.findElement(By.xpath("//span[.='Mac OS']"));
         WebElement Windows=driver.findElement(By.xpath("//span[.='Windows']"));
         WebElement Linux= driver.findElement(By.xpath("//span[.='Linux']"));

        Assert.assertTrue(Mac.isDisplayed());

        Assert.assertTrue(Windows.isDisplayed());

        Assert.assertTrue(Linux.isDisplayed());



    }

    public void teardown(){
        driver.close();
    }
}
