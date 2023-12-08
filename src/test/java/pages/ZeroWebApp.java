package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebApp
{
    public ZeroWebApp()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "icon-signin")
    public WebElement signIn;

    @FindBy(id = "user_login")
    public WebElement userLogin;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy (id = "pay_bills_link")
    public WebElement payBills;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchase;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;


}
