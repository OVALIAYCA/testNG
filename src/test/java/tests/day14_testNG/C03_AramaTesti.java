package tests.day14_testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class C03_AramaTesti
{
    // gerekli ayarlari yapip
    // 3 test method'u olusturun
    // 1- testotomasyonu anasayfaya gidip
    //    dogru adrese gittigimizi test edin
    // 2- phone icin arama yapip
    //    arama sonucunda urun bulunabildigini test edin
    // 3- ilk urune tiklayip
    //    acilan urun sayfasinda, urun isminin case sensitive olmadan phone icerdigini test edin

    WebDriver driver;
    @Test
    public void anaSayfaTesti()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- testotomasyonu anasayfaya gidip
        //    dogru adrese gittigimizi test edin
        driver.get("https://www.testotomasyonu.com");
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test (dependsOnMethods = "anaSayfaTesti")
    public void aramaTesti()
    {
        // 2- phone icin arama yapip
        //    arama sonucunda urun bulunabildigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));
        String unexpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unexpectedSonucYazisi,actualSonucYazisi);
    }

    @Test (dependsOnMethods = "aramaTesti")
    public void urunIsimTesti()
    {
        // 3- ilk urune tiklayip
        //    acilan urun sayfasinda, urun isminin case sensitive olmadan phone icerdigini test edin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedIcerik = "phone";
        String actualIcerik = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        driver.quit();
    }
}
