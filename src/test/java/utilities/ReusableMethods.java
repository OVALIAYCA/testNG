package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi)
    {
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }

    public static void bekle(int saniye)
    {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void titleIleSayfaDegistir(String hedefSayfaTitle)
    {


    Set<String> tumWHdegerSet = Driver.getDriver().getWindowHandles();

        for (String each
             :tumWHdegerSet
             )
        {
           String eachTitle = Driver.getDriver().switchTo().window(each).getTitle();
           if (eachTitle.equals(hedefSayfaTitle)){
               break;
           }
        }

       // System.out.println("ilk sayfa windowhandle : " + ilkSayfaWH);
       // System.out.println("tüm window handle set : " + tumWHdegerSet);

    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWH)
    {

        Set<String> tumWHSet = driver.getWindowHandles();
        tumWHSet.remove(ilkSayfaWH);
        for (String each:tumWHSet
             )
        {
            return  each;
        }

        return null;
    }

    public static void tumSayfaScreenshot(WebDriver driver)
    {


        //tüm sayfanın ekran görüntüsünü alıp kaydedin
        //1.takescreenshot objesi oluştur.cast yaparız.
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2.fotoğrafı kaydedeceğimiz dosya yolu ile bir file oluştur
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenShot/tumSayfaScreenShot"
                +localDateTime.format(istenenFormat)+".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        //3.TSS objesini kullanarak fotoğrafı çekip, geçici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4. geçici dosyayı asıl dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(2);

    }
    public static void istenenWebElementScreenshot (WebElement istenenWebElement)
    {
        //1. screenshot alacağımız webelementi locate et

        //2. screenshot kaydedeğimiz file'ı oluşturalım.
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenShot/istenenWebElementScreenshotScreenShot"
                +localDateTime.format(istenenFormat)+".jpg";

        File istenenWebelementSreenshot =new File(dinamikDosyaYolu);
        //3.web element üzerinden screenshot'ı alıp geçici bir dosyaya kaydedin
        File geciciDosya = istenenWebElement.getScreenshotAs(OutputType.FILE);
        //4.geçici dosyayı asıl dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,istenenWebelementSreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot kopyalanamadı");
            throw new RuntimeException(e);
        }
    }
}
