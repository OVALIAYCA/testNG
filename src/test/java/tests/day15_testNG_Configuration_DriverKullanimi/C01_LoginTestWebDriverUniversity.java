package tests.day15_testNG_Configuration_DriverKullanimi;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityLogIn;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_LoginTestWebDriverUniversity
{
    @Test
    public void negatifLoginTesti()
    {
        //1.“http://webdriveruniversity.com/” adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        //2.“Login Portal” a kadar asagi inin
        WebDriverUniversityLogIn webDriverUniversityLogIn = new WebDriverUniversityLogIn();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webDriverUniversityLogIn.logInPortal);

        //3.“Login Portal” a tiklayin
        webDriverUniversityLogIn.logInPortal.click();

        //4.Diger window’a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");

        //5.“username” ve “password” kutularina rastgele deger yazdirin
         Faker faker = new Faker();
         webDriverUniversityLogIn.userNameKutusu.sendKeys(faker.name().username());
         webDriverUniversityLogIn.passwordKutusu.sendKeys(faker.internet().password());

        //6.“login” butonuna basin
        webDriverUniversityLogIn.loginButton.click();

        //7.Popup’ta cikan yazinin “validation failed” oldugunu test edin
        //alert yazısında ayarlardaki sayfayı maximize et kısmı hata verdiriyor.
        //o yüzden if içine aldık driver class'ında.

        ReusableMethods.bekle(1);
        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);


        //8.Ok diyerek Popup’i kapatin
        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        String ilkSayfaTitle = "WebDriverUniversity.com";
        ReusableMethods.titleIleSayfaDegistir(ilkSayfaTitle);

        //10.Ilk sayfaya donuldugunu test edin
        ReusableMethods.bekle(1);
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,ilkSayfaTitle);
        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
