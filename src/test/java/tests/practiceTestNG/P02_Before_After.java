package tests.practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class P02_Before_After
{
    @BeforeClass //tüm testlerden önce 1 kere çalışır
    public void setUp()
    {
        System.out.println("tüm testler çalıştırılmaya başlanıyor.");
    }

    @Test
    public void wise()
    {
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }

    @AfterClass
    public void tearDown()
    {
        System.out.println("çalıştırılabilecek tüm testler çalıştı.");
        Driver.closeDriver();
    }


}
