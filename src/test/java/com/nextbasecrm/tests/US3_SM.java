package com.nextbasecrm.tests;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*  As a user, I should log out from the NextBaseCRM app.
    1. The “Log out” option should be displayed when the user clicks the user profile from the homepage.
    2. After clicking the logout button, the user should navigate back to the login page.*///testREQUIREMENTS
public class US3_SM {
    public WebDriver driver;
    @BeforeMethod public void setupLogin(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            inputUsername.sendKeys("marketing13@cybertekschool.com");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            inputPassword.sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        BrowserUtils.sleep(1);
    }

    @Test public void logOut2MainPg(){
        //1.The “Log out” option should be displayed when the user clicks the user profile from the homepage.
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        BrowserUtils.sleep(3);

        WebElement myLogOut = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][.='Log out']"));
        Assert.assertEquals(myLogOut.getText(),"Log out");
        myLogOut.click();

        //2. After clicking the logout button, the user should navigate back to the login page.


    }

    @AfterMethod
    public void tearDown() {
        //BrowserUtils.sleep(9);
        driver.close();
    }
}