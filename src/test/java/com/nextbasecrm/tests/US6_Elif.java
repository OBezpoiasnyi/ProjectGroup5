package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class US6_Elif {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");


    }

    @Test
    public void logIn() {
        WebElement inputUsername = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }


         //driver.findElement(By.id("feed-add-post-form-link-text")).click();
    @Test
    public  void moreButton(){

      //  WebElement moreButtonClick = driver.findElement(By.id("feed-add-post-form-link-text"));
       // moreButtonClick.click();

        WebElement popup = driver.findElement(By.xpath("//div[@class='menu-popup']"));
        popup.isDisplayed();
    }













    }

