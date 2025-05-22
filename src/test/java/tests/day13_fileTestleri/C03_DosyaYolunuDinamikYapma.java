package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // bilgisayar masaustunde selenium.txt
        // dosyasinin varoldugunu test edin

        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/selenium.txt";

        // C:\\Users\\casper\\Desktop\\Selenium.txt
        // C:/Users/yusuf/OneDrive/Desktop/selenium.txt
        // C:\\Users\\RIDVAN\\Desktop\\selenium.txt

        // Kodun herkeste calismasi icin dosya yolunu dinamik yapmaliyiz
        // dosya yollarini incelerseniz
        // herkesin en sondaki  "Desktop/selenium.txt" kismi ORTAK
        // Desktop'a kadar olan kisim herkeste FARKLI

        // String dosyaYolu = herkesteFarkliOlanKisim       + herkesteAyniOlanKisim

        //                    /Users/ahmetbulutluoz/        +  Desktop/selenium.txt
        //                    C:\\Users\\casper\\           +  Desktop\\Selenium.txt
        //                    C:\\Users\\RIDVAN\\           +  Desktop\\selenium.txt

        // Java herkeste farkli olan BASTAKI KISIM icin bize
        // dinamik bir kod hazirlamis

        System.out.println(System.getProperty("user.home"));
        // /Users/ahmetbulutluoz
        // butun bilgisayarlar icin home dosya yolunu verir
        // Download, Desktop .... gibi klasorler
        // bu home dosya yolundan sonra gelir

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));



        //                          herkesteFarkliOlanKisim       + herkesteAyniOlanKisim
        String dinamikDosyaYolu =  System.getProperty("user.home") + "/Desktop/selenium.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));










    }
}
