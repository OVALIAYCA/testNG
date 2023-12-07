package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority
{
    @Test
    public void youtubeTesti(){
        System.out.println("youtube testi PASSED");
    }

    @Test (priority = 5)
    public void testOtomasyonuTesti(){
        System.out.println("testotomasyonu testi PASSED");
    }

    @Test (priority = -5)
    public void wiseQuarterTest(){
        System.out.println("wisequarter testi PASSED");

    }

    @Test (priority = 20)
    public void amazonTesti(){

        System.out.println("amazon testi PASSED");
    }

    /*
    Test NG methodlarini default olarak natural order ile çalıştırır
    yani harf sırasına göre çalıştırır

    eğer biz istediğimiz sırada çalıştırmak isterser priority ile sıralama
    yapabiliriz.
    Priority değeri küçük olan önce çalışır
    Eğer priority aynı olursa harf sırasına bakar.
    Priority atanmazsa En önce o test çalışır. Default olarak 0 atanır priority sine.
    sonra diğer testler sırası ile çalışır.
    Priority - negatif sayı ise sayı sıralamasına bak.




    natural sıralama ile ;
    amazon testi PASSED
    testotomasyonu testi PASSED
    wisequarter testi PASSED
    youtube testi PASSED

     */
}
