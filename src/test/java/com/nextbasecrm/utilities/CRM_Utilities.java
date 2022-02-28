package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
      This method will Log In   with helpdesk1@cybertekschool.com user when it is called
       */
    public static void crm_login(WebDriver driver){
        //Method #1 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver

        //3. Enter valid username

        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk14@cybertekschool.com");



        BrowserUtils.sleep(3);
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        BrowserUtils.sleep(3);
        //5. Click to Log In button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    public static void crm_login(WebDriver driver,String username,String password){
        //Method #2 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String username
        //• Arg3: String password

        //3. Enter valid username

        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }






}
