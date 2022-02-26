package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Username_Password;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US7_Gulustan {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

        Username_Password.username1(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-item-link-text']")).getText(), "Activity Stream");
    }
   @AfterMethod
           public void  tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
   }




        @Test
                public void test1()  {


            WebElement pollButton = driver.findElement(By.xpath("//span[.='Poll']/span"));
           BrowserUtils.sleep(3);
            pollButton.click();

            WebElement clickOneAnswer=driver.findElement(By.xpath("(//span[@class='bx-vote-block-inp-substitute'])[1]"));
           BrowserUtils.sleep(3);
            clickOneAnswer.click();

            WebElement clickVote=driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[2]"));
           BrowserUtils.sleep(3);
            clickVote.click();

        }











}
