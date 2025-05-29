package tests.day18_sceenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_IsimliWebElementScreenshot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);

        // arama sonucu elementinin screenshot'ini alip kaydedin
        ReusableMethods.webElementResimCek(aramaSonucElementi,"aramaSonucu");


        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();


        // acilan sayfada urun isminde case sensitive olmadan
        // phone bulundugunu test edin

        String expectedIsimIcerik = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualIsim = urunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        // rapora eklemek icin urun isim elementinin screenshot'ini alip kaydedin

        ReusableMethods.webElementResimCek(urunIsimElementi,"urunIsmi");

    }
}
