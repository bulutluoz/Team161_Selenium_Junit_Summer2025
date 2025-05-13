package tests.day06_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

public class C06_AfterEachMantikliMi {

    /*
        Biz @Before... ve @After... method'lari kullanmadan da
        @Test method'lari olusturabiliriz

        ANCAKKKKKKK
        Eger before ve after method'lari kullanmazsak 2 negatif durum olusur
        1- birden fazla test method'umuz varsa
           her bir test method'u icin bastaki ayarlamalari
           ve sondaki kapatmayi
           tekrar tekrar yazmamiz gerekir
           (Kodlamada en istenmeyen sey kod tekraridir)

         2- test methodunun icinde
            en sonda driver.quit() kullanirsak
            test method'u icinde kodlarda hata oldugunda
            quit() calismaz
            YAANNNNIIII failed olan her test method'u icin browser acik kalir

         Bu iki sebepten dolayi
         ister tekbir test() olsun
         isterse cok test() olsun
         Before ve After notasyonlarini KULLANMALIYIZ

         Before ve After notasyonlarini KULLANMANIN
         bir diger artisi da
         @Test method'larinda SADECE testlere odaklanmamiz
         driver olusturmak, ayarlamalar yapmak veya driver'i kapatmak gibi
         detaylari Test()'nun disina atmis oluyoruz

     */

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testotomasyonuTest(){

        // Testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        String unexpectedSonucYazisi = "0 Products Found";
        WebElement aramaSonucuElementi = driver.findElement(By.className("product-count-text"));

        String actualSonucYazisi = aramaSonucuElementi.getText();

        if (actualSonucYazisi.equals(unexpectedSonucYazisi)){
            System.out.println("Arama testi FAILED");
            throw new AssertionFailedError("Arama sonucunda urun bulunamadi");
        } else {
            System.out.println("Arama testi PASSED");
        }
        // sayfayi kapatin

    }


}
