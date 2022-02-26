package com.nextbasecrm.tests;

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

        @Test
                public void test1() throws InterruptedException {


            WebElement pollButton = driver.findElement(By.xpath("//span[.='Poll']/span"));
            Thread.sleep(2000);
            pollButton.click();

            WebElement clickOneAnswer=driver.findElement(By.xpath("(//span[@class='bx-vote-block-inp-substitute'])[1]"));
            Thread.sleep(2000);
            clickOneAnswer.click();

            WebElement clickVote=driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[2]"));
            Thread.sleep(2000);
            clickVote.click();

        }











}
