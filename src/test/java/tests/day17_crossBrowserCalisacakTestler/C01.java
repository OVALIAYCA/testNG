package tests.day17_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

import java.util.List;

public class C01 extends TestBaseCross
{
    @Test
    public void aramaTesti()
    {
        //crossBrowser yapacaksak Driver.getdriver methodu kullanamayız.
        //driver ile çalışıyoruz ve extends TestBaseCross yapıyoruz.

        driver.get(ConfigReader.getProperty("toUrl"));

        //phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //arama sonucunda ürün bulunabildiğini test edin.
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class= 'product-box my-2  py-1']"));
        int actualSonucSayisi = bulunanUrunElementleriList.size();
        Assert.assertTrue(actualSonucSayisi>0);




    }
}
