package org.KylieCosmetics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFunctionalityTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    SearchProduct searchFunctionality;
    TearDownPage tearDown;

    @Test(priority = 1)
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("chrome","https://kyliecosmetics.com/en-in");
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        searchFunctionality = PageFactory.initElements(driver, SearchProduct.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    void setCookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    /*@Test(priority = 3)
    public void SearchFunctionality() throws InterruptedException
    {
        searchFunctionality.searchFunctionality("lipstick");

        String expectedURL = "https://kyliecosmetics.com/en-in";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }*/
    @Test(priority = 3)
    public void verifySearch()
    {
        driver.findElement(By.xpath("//a[@title='Search']")).click();
        //WebElement searchBox = driver.findElement(By.xpath("//a[@title='Search']"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("lipstick", Keys.ENTER);

        String expectedURL = "https://kyliecosmetics.com/en-in/search?q=lipstick";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test(priority = 4)
    public void teardown()
    {
        tearDown.teardown();
    }
}
