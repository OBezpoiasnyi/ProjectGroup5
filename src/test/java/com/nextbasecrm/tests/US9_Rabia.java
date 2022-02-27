package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9_Rabia {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        driver.findElement(By.name("USER_LOGIN")).sendKeys(ConfigurationReader.getProperty("username1"));
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Test
    public void moduleActivityStream(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ActivityStreamButton = driver.findElement(By.linkText("Activity Stream"));
        ActivityStreamButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void moduleChatAndCalls(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ChatAndCallsButton = driver.findElement(By.linkText("Chat and Calls"));
        ChatAndCallsButton.click();

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Chat and Calls";

        Assert.assertEquals(actualTitle2,expectedTitle2);

    }

    @Test
    public void moduleWorkGroups(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement WorkGroupsButton = driver.findElement(By.linkText("Workgroups"));
        WorkGroupsButton.click();

        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "Workgroups and projects";

        Assert.assertEquals(actualTitle3,expectedTitle3);
    }

    @Test
    public void moduleDrive(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement DriveButton = driver.findElement(By.linkText("Drive"));
        DriveButton.click();

        String actualTitle4 = driver.getTitle();
        String expectedTitle4 = "Site map";

        Assert.assertEquals(actualTitle4,expectedTitle4);
    }

    @Test
    public void moduleCalendar(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement CalendarButton = driver.findElement(By.linkText("Calendar"));
        CalendarButton.click();

        String actualTitle5 = driver.getTitle();
        String expectedTitle5 = "Site map";

        Assert.assertEquals(actualTitle5,expectedTitle5);
    }

    @Test
    public void moduleContactCenter(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ContactCenterButton = driver.findElement(By.linkText("Contact Center"));
        ContactCenterButton.click();

        String actualTitle6 = driver.getTitle();
        String expectedTitle6 = "Contact Center";

        Assert.assertEquals(actualTitle6,expectedTitle6);
    }

    @Test
    public void moduleTimeAndReports(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement TimeAndReportsButton = driver.findElement(By.linkText("Time and Reports"));
        TimeAndReportsButton.click();

        String actualTitle7 = driver.getTitle();
        String expectedTitle7 = "Absence Chart";

        Assert.assertEquals(actualTitle7,expectedTitle7);
    }

    @Test
    public void moduleEmployees(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement EmployeesButton = driver.findElement(By.linkText("Employees"));
        EmployeesButton.click();

        String actualTitle8 = driver.getTitle();
        String expectedTitle8 = "Company Structure";

        Assert.assertEquals(actualTitle8,expectedTitle8);
    }

    @Test
    public void moduleServices(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ServicesButton = driver.findElement(By.linkText("Services"));
        ServicesButton.click();

        String actualTitle9 = driver.getTitle();
        String expectedTitle9 = "Meeting Rooms";

        Assert.assertEquals(actualTitle9,expectedTitle9);
    }

    @Test
    public void moduleCompany(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement CompanyButton = driver.findElement(By.linkText("Company"));
        CompanyButton.click();

        String actualTitle10 = driver.getTitle();
        String expectedTitle10 = "Company";

        Assert.assertEquals(actualTitle10,expectedTitle10);
    }

}
