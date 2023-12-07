package tests.day15_testNG_Configuration_DriverKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Collection;

public class C04_NegatifLoginTesti

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // 2- login linkine basin
        // 3- 3 farkli test method’u olusturun.
        // - gecerli username, gecersiz password
        // - gecersiz username, gecerli password
        // - gecersiz username, gecersiz password.
        // 4- Login butonuna basarak login olun
        // 5- Basarili olarak giris yapilamadigini test edin
{
    @Test
    public void gecersizPasswordTesti()
    {
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();


        // - gecerli username, gecersiz password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olun
        testOtomasyonuPage.signInButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());


        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
    @Test
    public void gecersizEmailTesti()
    {
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();


        // - gecersiz username, gecerli password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 4- Login butonuna basarak login olun
        testOtomasyonuPage.signInButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());


        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti()
    {
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();


        // - gecersiz username, gecersiz password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olun
        testOtomasyonuPage.signInButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());


        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
