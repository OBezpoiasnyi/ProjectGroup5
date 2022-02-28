package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US8_Rukiye {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env"));

    }

    /*
    @Test
    public void crm_login_test() {
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr14@cybertekschool.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

 */
    @Test
    public void chat_and_call_module() {

        CRM_Utilities.crm_login(driver);

        WebElement chatAndCallModules = driver.findElement(By.xpath("//*[@id='bx_left_menu_menu_im_messenger']"));
        BrowserUtils.sleep(5);

        chatAndCallModules.click();
        BrowserUtils.sleep(5);

        WebElement messageIcon = driver.findElement(By.xpath("//div[@id='bx-desktop-tab-notify']"));
        Assert.assertTrue(messageIcon.isDisplayed());


        WebElement notificationIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-notify']"));
        Assert.assertTrue(notificationIcon.isDisplayed());


        WebElement settingIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-config']"));
        Assert.assertTrue(messageIcon.isDisplayed());


        WebElement activityStreamIcon = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im-lf']"));
        Assert.assertTrue(activityStreamIcon.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }
}




