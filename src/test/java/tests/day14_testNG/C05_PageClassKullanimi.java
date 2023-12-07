package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PageClassKullanimi
{
    @Test
    public void aramaTesti()
    {

        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);

        //phone için arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage(); //obje oluşturup istediklerimizi kullanabiliriz
        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        ReusableMethods.bekle(3);

        //bulunan sonuç sayısının 1'den çok olduğunu test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>1);


        //arama sonuç sayısını yazdırın
        System.out.println(testOtomasyonuPage.sonucYaziElementi.getText());
        ReusableMethods.bekle(2);
        //sayfayı kapatın

        Driver.quitDriver();

    }
}
