package tests.day13_fileTestleri;

import org.junit.jupiter.api.Test;
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
         */

        //Upload butonuna basalim.

        //“File Uploaded!” textinin goruntulendigini test edelim.
    }
}
