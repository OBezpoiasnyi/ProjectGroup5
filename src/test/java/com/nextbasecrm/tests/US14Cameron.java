package com.nextbasecrm.tests;

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
        driver.get("https://login1.nextbasecrm.com/stream/?login=yes");
    }
    @Test
    public void test(){
        WebElement log=driver.findElement(By.xpath("//input[contains(@name,'LOG')]"));
        log.sendKeys("helpdesk1@cybertekschool.com"+ Keys.TAB);
        WebElement pass=driver.findElement(By.xpath("//input[contains(@name,'PASS')]"));
        pass.sendKeys("UserUser"+Keys.ENTER);

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 500)");
         WebElement Mac= driver.findElement(By.xpath("//span[.='Mac OS']"));
         WebElement Windows=driver.findElement(By.xpath("//span[.='Windows']"));
         WebElement Linux= driver.findElement(By.xpath("//span[.='Linux']"));

        Assert.assertTrue(Mac.isDisplayed());

        Assert.assertTrue(Windows.isDisplayed());

        Assert.assertTrue(Linux.isDisplayed());



    }
}
