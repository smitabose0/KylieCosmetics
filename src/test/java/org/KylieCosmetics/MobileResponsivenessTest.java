package org.KylieCosmetics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MobileResponsivenessTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    TearDownPage tearDown;
    MobileLoginPage login;
    SearchPage search;

    @BeforeTest
    public void setUp() throws Exception
    {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // navigate to website
        driver.get("https://kyliecosmetics.com/en-in");
        // resize window to mobile device screen size
        driver.manage().window().setSize(new Dimension(360, 740));
        Thread.sleep(1000);
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //driver = new ChromeDriver(capabilities);
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
        login = PageFactory.initElements(driver, MobileLoginPage.class);
        search = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test(priority = 1)
    public void CookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 2)
    public void menuIcon() throws InterruptedException
    {
        // check that website elements are displayed correctly
        WebElement menuIcon = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[3]/a"));
        Assert.assertTrue(menuIcon.isDisplayed());
        Thread.sleep(2000);

        menuIcon.click();
    }
    @Test(priority = 3)
    public void setLogin()
    {
        try
        {
            WebElement accountIcon = driver.findElement(By.xpath("//a[@href='/en-in/account/login']"));
            if (((WebElement) accountIcon).isDisplayed())
            {
                Assert.assertTrue(accountIcon.isDisplayed());
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException | InterruptedException e)
        {
            // Handle exception if the element is not found
        }
        login.login("jivadixit1@gmail.com","Smita@0987");
    }
    public void search() throws InterruptedException
    {
        search.search("eyeliner");
    }
    @AfterTest
    public void tearDown() throws Exception
    {
        //driver.quit();
        tearDown.teardown();
    }
}
