package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){

        // day 13 package'i altinda
        // notlar.txt dosyasi bulundugunu test edin

        String dosyaYolu = "src/test/java/tests/day13_fileTestleri/notlar.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // bilgisayar masaustunde selenium.txt
        // dosyasinin varoldugunu test edin

        dosyaYolu = "/Users/ahmetbulutluoz/Desktop/selenium.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
