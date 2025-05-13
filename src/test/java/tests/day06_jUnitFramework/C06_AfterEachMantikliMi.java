package tests.day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

public class C06_AfterEachMantikliMi {


    @Test
    public void testotomasyonuTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        driver.quit();
    }


}
