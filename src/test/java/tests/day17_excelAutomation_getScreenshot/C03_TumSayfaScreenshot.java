package tests.day17_excelAutomation_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBase_Each;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);


        // rapora eklemek icin arama sonuc sayfasinin screenshot'ini alin

        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/tumSayfaScreenshot.jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        FileUtils.copyFile(geciciResim,file);
    }
}
