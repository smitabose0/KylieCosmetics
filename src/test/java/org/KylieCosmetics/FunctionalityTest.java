package org.KylieCosmetics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FunctionalityTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    LoginPage login;
    SearchProduct searchProduct;
    ProductDetailsPage productDetails;
    TearDownPage tearDown;
    WishListPage wishList;

    @Test(priority = 1)
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("chrome","https://kyliecosmetics.com/en-in");
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        login = PageFactory.initElements(driver, LoginPage.class);
        searchProduct = PageFactory.initElements(driver, SearchProduct.class);
        productDetails = PageFactory.initElements(driver, ProductDetailsPage.class);
        wishList = PageFactory.initElements(driver, WishListPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    public void CookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 3)
    public void login() throws InterruptedException
    {
        login.loginToWebsite("jivadixit1@gmail.com","Smita@0987");
    }
    @Test(priority = 4)
    public void search() throws InterruptedException
    {
        searchProduct.searchFunctionality("lipstick");
    }
    @Test(priority = 5)
    public void getProductDetails()
    {
        productDetails.getProductDetails();
    }
    @Test(priority = 6)
    public void addToWishlist() throws InterruptedException
    {
        //driver.findElement(By.xpath("//span[@class='wishlist-button__icon icon icon--heart-outline']")).click();
        //driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16612516069618__main\"]/div/article/div[2]/div/div[2]/div/div[1]/div/button")).click();
        Thread.sleep(3000);
        try
        {
            //WebElement addToCartButton = driver.findElement(By.xpath("//button[@type='button' and @title='add to wishlist']"));
            WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='badges-container']//span[@class='wishlist-button__icon icon icon--heart-outline']"));
            if (((WebElement) addToCartButton).isDisplayed())
            {
                addToCartButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }
    @Test(priority = 7)
    public void checkWishList() throws InterruptedException
    {
        wishList.checkWishlist();
    }
    @Test (priority = 8)
    public void productAddToCart() throws InterruptedException
    {
        try
        {
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[2]/article/div/div/div[2]/button"));
            if (((WebElement) addToCartButton).isDisplayed())
            {
                addToCartButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }
    @Test (priority = 9)
    public void checkoutProduct() throws InterruptedException
    {
        //driver.findElement(By.xpath("//*[@id=\"MiniCart-Checkout\"]")).click();
        //Thread.sleep(3000);
        try
        {
            WebElement checkoutButton = driver.findElement(By.xpath("//*[@id=\"MiniCart-Checkout\"]"));
            if (((WebElement) checkoutButton).isDisplayed())
            {
                checkoutButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }
    @Test(priority = 10)
    public void teardown()
    {
        tearDown.teardown();
    }
}
