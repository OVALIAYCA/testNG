package tests.Day17_testNGReports_dataProvider_crossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegatifLoginTesti
{
    @DataProvider
    public static Object[][] kullaniciBilgileriDP() {

        String[][] kullaniciBilgileri ={{"kullanici1", "12345"},
                {"kullanici2", "23456"}, {"kullanici3", "34567"},
                {"kullanici4", "45678"}, {"kullanici5", "56789"}};

        return kullaniciBilgileri;
    }
    @Test (dataProvider = "kullaniciBilgileriDP")
    public void cokluNegatifLoginTesti(String username, String password)
    {
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();

        // kullanici adi ve sifre olarak verilen listedeki
        testOtomasyonuPage.emailKutusu.sendKeys(username);
        testOtomasyonuPage.passwordKutusu.sendKeys(password);
        testOtomasyonuPage.signInButonu.click();

        // tum degerler icin giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());

        // kullanici1   12345
        // kullanici2   23456
        // kullanici3   34567
        // kullanici4   45678
        // kullanici5   56789
    }
}
