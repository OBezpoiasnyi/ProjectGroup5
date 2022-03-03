package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory_1 {

   public WebDriver driver;

   @BeforeMethod
   public void setUp() {
      driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  1-go to login page
      driver.get(ConfigurationReader.getProperty("env"));

   }

      @Test  public void verifyTitle(){

         //2. Go to https://login2.nextbasecrm.com/
         driver.navigate().to("https://login2.nextbasecrm.com/");
         // 4. Verify title:
         //Expected: “Authorization”
         String expectedTitle = "Authorization";
         String actualTitle = driver.getTitle();

         if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
         } else {
            System.out.println("Title verification FAILED!!!");
         }


      }
      // Enter valid emails and passwords

      @Test public void validLogin (){


         // username
         WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
         inputUsername.sendKeys("hr5@cydeo.com");

         //password
         WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
         inputPassword.sendKeys("UserUser");

         WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
         loginButton.click();



      }









  }
