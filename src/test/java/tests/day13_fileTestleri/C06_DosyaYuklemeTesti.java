package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_DosyaYuklemeTesti extends TestBase_Each {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz notlar.txt dosyasini secelim.
        /*
            Bir dosya yuklemek icin
            once dosyayi secmemiz gerekiyor
            ANCAKKKK dosya secmemiz icin acilan window
            web'de degil bizim bilgisayarimizda oldugundan
            WebDriver objesi acilan window'dan dosya SECEMEZ

            Biz dosya secemedigimiz icin
            Selenium buna bir cozum uretmistir

            dosyayi mouse ile tiklayip secmek yerine
            dosya sec butonuna
            yuklemek istedigimiz dosyanin dosyaYolunu yollamamiz yeterli olacaktir.
         */

        // dinamik olmadan
        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team161_JUnit/src/test/java/tests/day13_fileTestleri/notlar.txt";

        // dinamik olsun isterseniz
        String dinamikDosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/day13_fileTestleri/notlar.txt";

        // choose file butonunu locate edip kaydedelim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        // choose file butonuna dosya yolunu yollayalim
        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = fileUploadedYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


    }
}
