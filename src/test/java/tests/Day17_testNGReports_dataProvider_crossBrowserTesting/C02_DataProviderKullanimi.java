package tests.Day17_testNGReports_dataProvider_crossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_DataProviderKullanimi extends TestBaseRapor
{


    @Test
    public void cokluAramaTesti()
    {

        /*
            Bugune kadar ogrendigimiz yontemlerle
            birden fazla eleman icin test yapmak istedigimizde
            elemanlari bir array'e atayip
            for loop ile testleri yapmak istedik

            ANCAK, ilk failed olan urunde
            assertion exception firlatip calismayi durdurdu
            geriye kalan urunlerin var olup olmadigini kontrol etmedi
         */

        String[] aranacakUrunler ={"phone", "java", "dress", "nutella", "chair", "tea"};
        String arananUrun;
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        int actualUrunSayisi;

        for (int i = 0; i < aranacakUrunler.length ; i++)
        {
            arananUrun = aranacakUrunler[i];


        //testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //verilen ürün listesindeki tüm ürünler için arama yapıp
        //ürün listesi : phone, java, dress, nutella, chair, tea.
        testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);



        //her bir ürün için arama yapıldığında sonuç bulunabildiğini test edin
        actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualUrunSayisi>0);

    }

 }

    @DataProvider
    public static Object[][] aranacakUrunlerDataProvider()
    {
        String[][] aranacakUrunler ={{"phone"}, {"java"}, {"dress"}, {"nutella"}, {"chair"}, {"tea"}};

        return aranacakUrunler;
    }
    @Test (dataProvider = "aranacakUrunlerDataProvider")
    public void dataProviderIleCokluAramaTesti(String arananUrun)
    {
        extentTest = extentReports.createTest("Arama testi","Kullanıcı belirlenen ürün listesi için arama yapabilmeli ");
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        //testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyonu anasayfaya gider");

        //verilen ürün listesindeki tüm ürünler için arama yapıp
        //ürün listesi : phone, java, dress, nutella, chair, tea.
        testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);
        extentTest.info("verilen ürün listesindeki "+arananUrun+" için arama yapar");
        ReusableMethods.bekle(2);



        //her bir ürün için arama yapıldığında sonuç bulunabildiğini test edin
        int actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualUrunSayisi>0);
        extentTest.pass(arananUrun + " için arama yapıldığında ürün bulunabildiğini test eder");


    }


}
