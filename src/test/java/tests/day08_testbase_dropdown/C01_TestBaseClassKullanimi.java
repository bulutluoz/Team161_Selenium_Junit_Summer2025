package tests.day08_testbase_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C01_TestBaseClassKullanimi extends TestBase_Each {

    /*
        Bir test class'i olusturdugumuzda
        ILK YAPMAMIZ GEREKEN SEY
        WedDriver Objesi EDINMEKTIR

        Bir class'da obje olusturmadan
        baska class'da olusturulmus objeyi edinmenin
        en KOLAY yolu INHERITANCE
     */

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // phone arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucuElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucuElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

    }
}
