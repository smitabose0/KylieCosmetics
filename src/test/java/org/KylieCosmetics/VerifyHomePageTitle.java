package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyHomePageTitle
{
    WebDriver driver;
    TearDownPage tearDown;

    @Test(priority = 1)
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("chrome","https://kyliecosmetics.com/en-in");
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    public void verifyTitle()
    {
        String expectedTitle = "Kylie Cosmetics by Kylie Jenner | Kylie Skin | Kylie Baby";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 3)
    public void teardown()
    {
        tearDown.teardown();
    }
}
