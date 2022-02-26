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

import java.util.concurrent.TimeUnit;

public class UserStory4 {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @AfterMethod
    public void tearDownMethod(){

        driver.close();

    }

    @Test
    public void test1() {  // Check if user3 see My Profile on Profile button

        Username_Password.username1(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        WebElement profile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        profile.click();

        WebElement myProfile = driver.findElement(By.xpath("//a[.='My Profile']"));


        Assert.assertEquals(myProfile.getText(), "My Profile");

        WebElement myEditProfileSetting = driver.findElement(By.xpath("//a[.='Edit Profile Settings']"));

        Assert.assertEquals(myEditProfileSetting.getText(),"Edit Profile Settings");

        WebElement myThemes = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Themes']"));

        Assert.assertEquals(myThemes.getText(), "Themes");

        WebElement myConfigureNotifications = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Configure notifications']"));

        Assert.assertEquals(myConfigureNotifications.getText(),"Configure notifications");

        WebElement myLogOut = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Log out']"));

        Assert.assertEquals(myLogOut.getText(),"Log out");

    }

    @Test
    public void test2() {  // Check if user3 see My Profile on Profile button

        Username_Password.username2(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        WebElement profile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        profile.click();

        WebElement myProfile = driver.findElement(By.xpath("//a[.='My Profile']"));


        Assert.assertEquals(myProfile.getText(), "My Profile");

        WebElement myEditProfileSetting = driver.findElement(By.xpath("//a[.='Edit Profile Settings']"));

        Assert.assertEquals(myEditProfileSetting.getText(),"Edit Profile Settings");

        WebElement myThemes = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Themes']"));

        Assert.assertEquals(myThemes.getText(), "Themes");

        WebElement myConfigureNotifications = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Configure notifications']"));

        Assert.assertEquals(myConfigureNotifications.getText(),"Configure notifications");

        WebElement myLogOut = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Log out']"));

        Assert.assertEquals(myLogOut.getText(),"Log out");

    }


    @Test
    public void test3() {  // Check if user3 see My Profile - Edit profile Settings -Themes -Configure notifications - Log out on Profile button

        Username_Password.username3(driver);

        WebElement rememberME_button = driver.findElement(By.id("USER_REMEMBER"));
        rememberME_button.click();

        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        WebElement profile = driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']"));
        profile.click();

        WebElement myProfile = driver.findElement(By.xpath("//a[.='My Profile']"));


        Assert.assertEquals(myProfile.getText(), "My Profile");

        WebElement myEditProfileSetting = driver.findElement(By.xpath("//a[.='Edit Profile Settings']"));

        Assert.assertEquals(myEditProfileSetting.getText(),"Edit Profile Settings");

        WebElement myThemes = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Themes']"));

        Assert.assertEquals(myThemes.getText(), "Themes");

        WebElement myConfigureNotifications = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Configure notifications']"));

        Assert.assertEquals(myConfigureNotifications.getText(),"Configure notifications");

        WebElement myLogOut = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Log out']"));

        Assert.assertEquals(myLogOut.getText(),"Log out");

    }



}
