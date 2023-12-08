package tests.practiceTestNG;

import org.testng.annotations.Test;

public class P01_TestNG
{
    @Test (priority = -5)
    public void deniz()
    {
        System.out.println("Deniz methodu çalıştı.");
    }

    @Test (priority = 35)
    public void ahmet()
    {
        System.out.println("Ahmet methodu çalıştı.");
    }

    @Test
    public void mehmet()
    {
        System.out.println("Mehmet methodu çalıştı.");
    }

    @Test  (dependsOnMethods = "mehmet")
    public void fikret()
    {
        System.out.println("Fikret methodu çalıştı.");
    }


    //priority vermeden önce ahmet-deniz-fikret-mehmet sıralaması ile çalıştı.
    //priority de sıralamaya göre çalışır. priority değer verilmeyen, default 0 değer alır.
    //dependınmethod yazılan methodun çalışmasına bağlı olarak mevcut methodu çalıştırır.



}
