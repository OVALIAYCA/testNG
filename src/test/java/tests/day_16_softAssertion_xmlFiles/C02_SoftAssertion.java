package tests.day_16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebApp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion
{
    @Test
    public void softAssertionTesti()
    {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toZeroUrl"));


        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin ((verify)soft assert olarak algıla)
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfaya gidemedi");


        // 2. Sign in butonuna basin
        ZeroWebApp zeroWebApp = new ZeroWebApp();
        zeroWebApp.signIn.click();
        ReusableMethods.bekle(2);

        // 4. Login kutusuna “username” yazin
        zeroWebApp.userLogin.sendKeys(ConfigReader.getProperty("toZeroLogin"));

        // 5. Password kutusuna “password” yazin
        zeroWebApp.password.sendKeys(ConfigReader.getProperty("toZeroPss"));


        // 6. Sign in tusuna basin
        zeroWebApp.submit.click();


        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();


        // 8. Giris yapilabildiginizi dogrulayin
        softAssert.assertTrue(zeroWebApp.onlineBanking.isDisplayed(),"Giriş yapılamadı");

        // 9. Online banking menusunu tiklayin
        zeroWebApp.onlineBanking.click();

        //10. Pay Bills sayfasina gidin
        zeroWebApp.payBills.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebApp.purchase.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebApp.currencyDropdown.isEnabled(),"Dropdown menusu kullanılamıyor.");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroWebApp.currencyDropdown);
        select.selectByValue("EUR");

        //14. “Eurozone (euro)” secildigini dogrulayin
        String expectedOption = "Eurozone (euro)";
        String actualOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOption,expectedOption,"Eurozone seçilemedi");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedDropdownSize = 16;
        int actualDropdownSize = select.getOptions().size();
        softAssert.assertEquals(actualDropdownSize,expectedDropdownSize,"Dropdown beklenen boyutta değil");


        //16. Dropdown menude “Canada (dollar)” bulunduğunu dogrulayin
        List<WebElement> dropdownList = select.getOptions();
       List<String> dropdownYazilariList = ReusableMethods.stringListeDonustur(dropdownList);
       softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdownda Canada doları yok");

        //17. Sayfayi kapatin
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
