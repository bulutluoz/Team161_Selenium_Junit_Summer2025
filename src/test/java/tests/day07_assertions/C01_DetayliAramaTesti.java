package tests.day07_assertions;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DetayliAramaTesti {
    // Testotomasyonu anasayfaya gidip
    // asagidaki gorevleri 3 farkli test method'u olarak olusturun
    // 1- url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
        Gorevler birbiri ile baglantili oldugundan
        @BeforeEach ve @AfterEach kullanirsak
        1.test method'u calisir
        ama 1.test method'undan sonra browser kapandigi icin
        2. ve 3. method'lar calisamaz

        Demek ki bir goreve baslamadan once
        driver'i en basta olusturup, en sonda kapatalim (...All)
        veya her method'dan once olusturup, her method'dan sonra kapatalim (...Each)
        tercihlerinden birini secmemiz gerekiyor
     */
    static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // anasayfaTesti
        // 1- url'in testotomasyonu icerdigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Anasayfa testi PASSED");
        }else {
            System.out.println("Anasayfa testi FAILED");
            throw new AssertionError("Url testotomasyonu icermiyor");
        }


    }

    @Test
    public void test02(){
        // phoneAramaTesti
        // 2- phone icin arama yapip,

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin

        String unExpectedSonucYazisi = "0 Products Found";

        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String actualSonucYazisi = aramaSonucYaziElementi.getText();

        if (actualSonucYazisi.equals(unExpectedSonucYazisi)){
            System.out.println("Urun arama testi FAILED");
            throw new AssertionError("Arama sonucunda urun bulunamadi");
        } else {
            System.out.println("Urun arama testi PASSED");
        }


    }

    @Test
    public void test03(){
        // ilkUrunIsimTesti

        // 3- ilk urunu tiklayip,

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // urun isminde case sensitive olmadan phone bulundugunu test edin
        String expectedUrunIsimIcerigi = "phone";

        WebElement ilkUrunSayfasindakiIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String actualUrunIsmi = ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        if (actualUrunIsmi.contains(expectedUrunIsimIcerigi)){
            System.out.println("Ilk urun isim testi PASSED");
        } else {
            System.out.println("Ilk urun isim testi FAILED");
            throw new AssertionError("Ilk urun ismi aranan kelimeyi icermiyor");
        }

    }

}
