package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class WebDriverUniversityLogIn
{
    public WebDriverUniversityLogIn()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement logInPortal;
    @FindBy(xpath = "//*[@id='text']")
    public WebElement userNameKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButton;

}
