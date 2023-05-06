package org.KylieCosmetics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SocialMediaLinksTest
{
    private WebDriver driver;
    JavascriptExecutor js;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://kyliecosmetics.com/en-in");
        driver.manage().window().maximize(); //Full screen.

        js = (JavascriptExecutor) driver;
    }
    @Test(priority = 1)
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }

    @Test(priority = 2)
    public void facebookTest() throws InterruptedException
    {
        js.executeScript("window.scrollTo(0,5500)");
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//div[@class='social-icon']/a[@arial-label='Facebook']")).click(); //img[@alt='Facebook']
        //driver.findElement(By.xpath("img[@alt='Facebook']")).click(); //img[@alt='Facebook']
        driver.findElement(By.cssSelector(".social-icon:nth-child(1) img")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void instagramTest() throws InterruptedException
    {
        driver.findElement(By.cssSelector(".social-icon:nth-child(2) img")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 4)
    public void twitterTest() throws InterruptedException
    {
        driver.findElement(By.cssSelector(".social-icon:nth-child(3) img")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
