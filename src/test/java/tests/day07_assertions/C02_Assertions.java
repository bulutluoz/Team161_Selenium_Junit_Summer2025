package tests.day07_assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

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

        // actualUrl expectedurlIcerik'ini iceriyor mu
        // sonuc true ise => test PASSED
        // sonuc false ise =>

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url istenen icerigi barindirmiyor");

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

        // actualSonucYazisi unExpectedSonucYazisina esit mi ?
        // esit ise ==>
        // esit degil ise ==> PASSED

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi,"Arama sonucunda urun bulunamadi");


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

        // actualUrunIsmi expectedUrunIsimIcerigi'ni iceriyor mu?
        // sonuc true ise => PASSED
        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi),"Urun ismi aranan kelimeyi icermiyor");


    }
}
