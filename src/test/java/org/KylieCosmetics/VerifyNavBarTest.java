package org.KylieCosmetics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyNavBarTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    TearDownPage tearDown;

    @Test(priority = 1)
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("chrome","https://kyliecosmetics.com/en-in");
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    void setCookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 3)
    public void verifyNavBar()
    {
        boolean navBarPresent = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]")).isDisplayed();
        Assert.assertTrue(navBarPresent,"not present");
    }

    @Test(priority = 4)
    public void teardown()
    {
        tearDown.teardown();
    }
}
