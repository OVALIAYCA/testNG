package tests.Day17_testNGReports_dataProvider_crossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor
{
    @Test
    public void aramaTesti()
    {
        extentTest = extentReports.createTest("Arama testi","Kullanıcı belirlenen ürün listesi için arama yapabilmeli ");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyonu sayfasına gider");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader
                          .getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi için arama yapar");

        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(aramaSonucSayisi>0);
        extentTest.pass("arama sonucunda ürün bulunabildiğini test eder");

        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk ürüne tıklar");

        String actualUrunElementi = testOtomasyonuPage
                                    .urunSayfasindakiUrunIsimElementi
                                    .getText()
                                    .toLowerCase();
        Assert.assertTrue(actualUrunElementi.contains(ConfigReader.getProperty("toAranacakKelime")));
        extentTest.pass("açılan ürün sayfasında ürün isminin case sensitive\n" +
                "olmadan belirlenen arama kelimesi içerğidini test eder");


        Driver.closeDriver();
        extentTest.info("sayfayı kapatır");
        //bu aşamaya kadar sadece normal
        //testimizi yaptık. Öncelikle raporun çalışması için extend testbaserapor yapmamız gerekiyor.
        //extentreports, extenthtmlreporter ve extenxt test obejsi çağırabiliriz.
        //diğer ikisine değer atamıştık ama extenttest e değer atamamıştır.
        //şimdi burada değer atayacağız.eb başta oluşturduk.








    }
}
