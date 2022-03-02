package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
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

        BrowserUtils.sleep(3);

        WebElement ActivityStreamButton = driver.findElement(By.linkText("Activity Stream"));
        ActivityStreamButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void moduleChatAndCalls(){

        BrowserUtils.sleep(3);

        WebElement ChatAndCallsButton = driver.findElement(By.linkText("Chat and Calls"));
        ChatAndCallsButton.click();

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Chat and Calls";

        Assert.assertEquals(actualTitle2,expectedTitle2);

    }

    @Test
    public void moduleWorkGroups(){

        BrowserUtils.sleep(3);

        WebElement WorkGroupsButton = driver.findElement(By.linkText("Workgroups"));
        WorkGroupsButton.click();

        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "Workgroups and projects";

        Assert.assertEquals(actualTitle3,expectedTitle3);
    }

    @Test
    public void moduleDrive(){

        BrowserUtils.sleep(3);

        WebElement DriveButton = driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[5]"));
        DriveButton.click();

        BrowserUtils.sleep(3);

        String actualTitle4 = driver.getTitle();
        String expectedTitle4 = "My Drive";

        Assert.assertEquals(actualTitle4,expectedTitle4);
    }

    @Test
    public void moduleCalendar(){

        BrowserUtils.sleep(3);

        WebElement CalendarButton = driver.findElement(By.linkText("Calendar"));
        CalendarButton.click();

        String actualTitle5 = driver.getTitle();
        String expectedTitle5 = "Hr15 Cydeo: Calendar";

        Assert.assertEquals(actualTitle5,expectedTitle5);
    }

    @Test
    public void moduleContactCenter(){

        BrowserUtils.sleep(3);

        WebElement ContactCenterButton = driver.findElement(By.linkText("Contact Center"));
        ContactCenterButton.click();

        String actualTitle6 = driver.getTitle();
        String expectedTitle6 = "Contact Center";

        Assert.assertEquals(actualTitle6,expectedTitle6);
    }

    @Test
    public void moduleTimeAndReports(){

        BrowserUtils.sleep(3);

        WebElement TimeAndReportsButton = driver.findElement(By.linkText("Time and Reports"));
        TimeAndReportsButton.click();

        String actualTitle7 = driver.getTitle();
        String expectedTitle7 = "Absence Chart";

        Assert.assertEquals(actualTitle7,expectedTitle7);
    }

    @Test
    public void moduleEmployees(){

        BrowserUtils.sleep(3);

        WebElement EmployeesButton = driver.findElement(By.linkText("Employees"));
        EmployeesButton.click();

        String actualTitle8 = driver.getTitle();
        String expectedTitle8 = "Company Structure";

        Assert.assertEquals(actualTitle8,expectedTitle8);
    }

    @Test
    public void moduleServices(){

        BrowserUtils.sleep(3);

        WebElement ServicesButton = driver.findElement(By.linkText("Services"));
        ServicesButton.click();

        String actualTitle9 = driver.getTitle();
        String expectedTitle9 = "Meeting Rooms";

        Assert.assertEquals(actualTitle9,expectedTitle9);
    }

    @Test
    public void moduleCompany(){

        BrowserUtils.sleep(3);

        WebElement CompanyButton = driver.findElement(By.linkText("Company"));
        CompanyButton.click();

        String actualTitle10 = driver.getTitle();
        String expectedTitle10 = "Company";

        Assert.assertEquals(actualTitle10,expectedTitle10);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }
}
