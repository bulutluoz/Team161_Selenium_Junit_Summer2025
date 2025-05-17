package tests.day10_iframe_switchingWindows;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_FarkliWindowAcilirsa extends TestBase_Each {

    @Test
    public void test01(){
        // https://testotomasyonu.com/discount gidin
        driver.get("https://testotomasyonu.com/discount");

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("discount Url : " + driver.getCurrentUrl());
        System.out.println("discount title : " + driver.getTitle());
        System.out.println("discount WHD : " + driver.getWindowHandle());
        System.out.println("discount acik tum WHD : " + driver.getWindowHandles());

        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // fashion bolumundeki ilk urunu tiklayin
        // once fashion iframe'ine gecmemiz gerekir
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo()
                .frame(fashionIframe);

        // ilk urunu tiklayalim
        driver.findElement(By.id("pic1_thumb"))
                .click();

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("Ilk urun Url : " + driver.getCurrentUrl());
        System.out.println("Ilk urun title : " + driver.getTitle());
        System.out.println("Ilk urun WHD : " + driver.getWindowHandle());
        System.out.println("Ilk urun acik tum WHD : " + driver.getWindowHandles());
        ReusableMethods.bekle(2);
        System.out.println("\n ================== \n");

        /*
            EGER bir linki tikliyorsaniz
            driver AYNI window'da FARKLI sayfa acacaginizi dusunur
            ve ilk acilan window'da bekler

            linke tikladigimizda
            yeni sayfa degil
            yeni window acilirsa
            driver'in bundan haberi olmaz
            eski window'da kalir
            test yapabilmemiz icin driver'i yeni window'a biz gecis yaptirmaliyiz

         */

    }
}
