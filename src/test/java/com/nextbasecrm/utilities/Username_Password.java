package com.nextbasecrm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Username_Password {

    public static void username1(WebDriver driver){

        WebElement username1 = driver.findElement(By.name("USER_LOGIN"));
        username1.clear();
        username1.sendKeys(ConfigurationReader.getProperty("username1"));

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    public static void username2(WebDriver driver){

        WebElement username2 = driver.findElement(By.name("USER_LOGIN"));
        username2.clear();
        username2.sendKeys(ConfigurationReader.getProperty("username2"));
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    public static void username3(WebDriver driver){

        WebElement username3 = driver.findElement(By.name("USER_LOGIN"));
        username3.clear();
        username3.sendKeys(ConfigurationReader.getProperty("username3"));

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

    }


}
