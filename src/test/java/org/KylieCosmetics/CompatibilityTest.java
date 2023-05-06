package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CompatibilityTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    TearDownPage tearDown;

    @Test (priority = 1)
    //@BeforeClass
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("safari","https://kyliecosmetics.com/en-in");
        //compatibility = PageFactory.initElements(driver, Compatibility.class);
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    void setCookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 3)
    public void teardown()
    {
        tearDown.teardown();
    }

}