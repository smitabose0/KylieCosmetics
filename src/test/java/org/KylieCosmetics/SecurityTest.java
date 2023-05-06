package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecurityTest
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
    public void testSSLCertificate()
    {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://kyliecosmetics.com/en-in";
        Assert.assertEquals(actualUrl, expectedUrl, "The website is not using HTTPS");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Kylie Cosmetics by Kylie Jenner | Kylie Skin | Kylie Baby";
        Assert.assertEquals(actualTitle, expectedTitle, "The website title is incorrect");
    }
    @Test(priority = 4)
    public void teardown()
    {
        tearDown.teardown();
    }
}
