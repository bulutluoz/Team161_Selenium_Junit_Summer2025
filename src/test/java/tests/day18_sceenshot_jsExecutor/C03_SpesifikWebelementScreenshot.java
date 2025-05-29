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

public class C03_SpesifikWebelementScreenshot extends TestBase_Each {

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

        // 1.adim : screenshot alacaginiz webelementi locate edip, kaydedin
        //          biz arama sonuc yazisi elementini zaten locate edip kaydetmistik

        // 2.adim : screenshot'i kaydedecegimiz dosyayi(File) olusturun
        String dosyaYolu = "target/screenshots/istenenWebElement.jpg";
        File asilResim = new File(dosyaYolu);

        // 3.adim : webElement'i kullanarak screenshot alip
        //          gecici bir dosyaya(File) kaydedin
        File geciciResim = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici resmi asil resme kopyalayin
        FileUtils.copyFile(geciciResim,asilResim);


        // ilk urunu tiklayin

        // acilan sayfada urun isminde case sensitive olmadan
        // phone bulundugunu test edin

        // rapora eklemek icin urun isim elementinin screenshot'ini alip kaydedin


    }
}
