package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookieConsentPage
{
    WebDriver driver;
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']") //@FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    WebElement cookieConsentButton;

    public CookieConsentPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCookieConsentButton()
    {
        cookieConsentButton.click();
    }
}
