package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadTimeTest
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
    public void websiteLoadTime()
    {
        long startTime = System.currentTimeMillis();

        // Navigate to the website
        driver.get("https://kyliecosmetics.com/");

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Load time: " + totalTime + " milliseconds");
    }
    @Test(priority = 3)
    public void teardown()
    {
        tearDown.teardown();
    }
}
