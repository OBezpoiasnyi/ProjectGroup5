package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US11_Oleksandr {


    public WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDownMethod(){

      driver.close();

    }



    @Test
    public void testProfileButton(){

        //1. The “My Profile” option should be displayed when the user clicks the user profile from the homepage.

        driver.get("https://login1.nextbasecrm.com");

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement userProfile = driver.findElement(By.xpath("//div[@id = 'user-block']"));
        userProfile.click();

        WebElement profileButton = driver.findElement(By.xpath("//span[. = 'My Profile']"));

        //1. The “My Profile” option should be displayed when the user clicks the user profile from the homepage.
        Assert.assertTrue(profileButton.isDisplayed(), "Profile button is not displayed after clicking the user profile from the homepage");

    }

    @Test
    public void testNavigationBar(){

        //2. There should be five tabs on my profile page:
        //       “General “Drive” “Tasks” “Calendar ” “conversations”

        driver.get("https://login1.nextbasecrm.com");

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement userProfile = driver.findElement(By.xpath("//div[@id = 'user-block']"));
        userProfile.click();

        WebElement profileButton = driver.findElement(By.xpath("//span[. = 'My Profile']"));
        profileButton.click();

        ArrayList <String> expectNavBar = new ArrayList<>();
        expectNavBar.addAll(Arrays.asList("General", "Drive", "Tasks", "Calendar" , "Conversations"));


        List<WebElement> navList = driver.findElements(By.xpath("//div[@id = 'profile-menu-filter']/a"));
        ArrayList<String> actualNavList = new ArrayList<>();

        for (WebElement webElement : navList) {
            actualNavList.add(webElement.getText());
        }

        Assert.assertEquals(expectNavBar, actualNavList, "There is not five tabs on my profile page");


    }

    //As a user, I want to access my profile page.

    //1. The “My Profile” option should be displayed when the user clicks the user profile from the homepage.
    //2. There should be five tabs on my profile page:
    //       “General “Drive” “Tasks” “Calendar ” “conversations”



}
