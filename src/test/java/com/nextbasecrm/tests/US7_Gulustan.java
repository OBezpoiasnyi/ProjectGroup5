package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.*;
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


    }



    @Test
      public void crm_login_test(){
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

}

        @Test
                public void test1()  {
            CRM_Utilities.crm_login(driver);

            WebElement pollButton = driver.findElement(By.xpath("//span[.='Poll']/span"));
            BrowserUtils.sleep(3);

            pollButton.click();
            BrowserUtils.sleep(3);


            WebElement clickOneAnswer=driver.findElement(By.xpath("(//span[@class='bx-vote-block-inp-substitute'])[1]"));
            BrowserUtils.sleep(3);

            clickOneAnswer.click();
            BrowserUtils.sleep(3);

            WebElement clickVote=driver.findElement(By.xpath("(//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[2]"));
            BrowserUtils.sleep(3);

            clickVote.click();
            BrowserUtils.sleep(3);
        }


    @AfterMethod
    public void  tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }








}
