package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion
{
    @Test
    public void softAssertionTest()
    {
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();

        // Title'in Test icerdigini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),"Title Test içermiyor");


        // url'in https://www.testotomasyonu.com oldugunu test edin
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farklı");

        // arama kutusunun kullanilabilir durumda oldugunu test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(),"Arama Kutusu kullanılamıyor");

        // belirlenmis aranacak kelimeyi aratip urun bulundugunu test edin
        testOtomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi>0,"Aranacak kelime için ürün bulunamadı");


        // Nutella aratip, urun bulunamadığını test edin
        ReusableMethods.bekle(2);
        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi==0,"Nutella bulundu");

        softAssert.assertAll();
        //bu basamak önemli.

        // sayfayi kapatin
        Driver.closeDriver();




    }
}
