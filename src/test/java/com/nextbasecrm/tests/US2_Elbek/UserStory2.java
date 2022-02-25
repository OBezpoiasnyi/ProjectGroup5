package com.nextbasecrm.tests.US2_Elbek;

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

public class UserStory2 {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @AfterMethod
    public void tearDownMethod(){

        driver.close();

    }

    @Test
    public void test1(){  // Check if user3 can click "Remember me checkbox

        Username_Password.username1(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-item-link-text']")).getText(), "Activity Stream");

    }

    @Test
    public void test2(){  // Check if user3 can click "Remember me checkbox

        Username_Password.username2(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-item-link-text']")).getText(), "Activity Stream");

    }

    @Test
    public void test3(){  // Check if user3 can click "Remember me checkbox

        Username_Password.username3(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-item-link-text']")).getText(), "Activity Stream");

    }

    @Test
    public void test4(){  // Confirm if the checkbox is displayed before "Remember me..." text

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']/following-sibling::label"));  // Checks if the checkbox is right before the "Remember me..." text
        Assert.assertEquals(rememberMe.getText(), "Remember me on this computer");

    }



}
