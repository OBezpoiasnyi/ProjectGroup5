package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US7_Gulustan {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }


    @Test
    public void one_answer_for_a_poll() {

        CRM_Utilities.crm_login(driver);

        //Writing "Programming language" in the search box and finding existing poll
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-textbox-input']"));
        searchInput.sendKeys("programming123" + Keys.ENTER);


        //finding "vote" button, and after clicking the vote, finding the "vote again" button locator
        WebElement voteAgainButton = driver.findElement(By.xpath("//input[@id='sessid']/..//button[.='Vote again']"));
        WebElement voteButton = driver.findElement(By.xpath("//input[@id='sessid']/..//button[.='Vote']"));
        voteAgainButton.click();

        //Location java and python answer options locator for clicking
        WebElement javaOption = driver.findElement(By.xpath("//li[@id='question35']//label[.='Java']"));
        WebElement pythonOption = driver.findElement(By.xpath("//li[@id='question35']//label[.='Python']"));

        //Java and python locator was not able to answer isSelected() method,
        // so I find other input locator option for java and python
        // This locator able to answer isSelected() method
        List<WebElement> IsSelectedOptions = driver.findElements(By.xpath("//input[@name='vote_radio_35']/..//input"));

        //Java   value attribute value  =>75
        //Python value attribute value  =>76

        //Verifying one option is selected at a time by verifying if it matches the attribute in their locator
        for (WebElement each : IsSelectedOptions) {
             javaOption.click();
          // pythonOption.click();
            BrowserUtils.sleep(2);
            if (each.getAttribute("value").equals("75")) {
                Assert.assertTrue(each.isSelected());
            }
        }


        //User click vote button and see if it is selected
        try {
            voteButton.click();
        } catch (StaleElementReferenceException e) {
            Assert.assertTrue(!(voteButton.isDisplayed()));
        }


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        // driver.quit();
    }

}










