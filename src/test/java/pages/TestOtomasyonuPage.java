package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage
{
    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "global-search")
    public WebElement aramaKutusu;


    @FindBy(className = "product-count-text")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//div[@class= 'product-box my-2  py-1']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement urunSayfasindakiUrunIsimElementi;

    @FindBy(xpath = "(//*[@class='menu-icon-text'])[1]")
    public WebElement accountButonu;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement signInButonu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutButon;










}
