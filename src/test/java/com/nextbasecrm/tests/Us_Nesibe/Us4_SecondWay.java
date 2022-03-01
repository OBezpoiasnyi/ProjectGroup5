package com.nextbasecrm.tests.Us_Nesibe;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Us4_SecondWay {


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
    public void test(){

        Username_Password.username1(driver);


        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        WebElement profile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        profile.click();

        List<WebElement> fiveOptions=driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));

        for (WebElement eachElement : fiveOptions) {
            Assert.assertTrue(eachElement.isDisplayed());
            System.out.println("eachElement = " + eachElement.getText());
        }

    }









}
