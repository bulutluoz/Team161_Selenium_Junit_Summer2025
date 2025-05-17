package tests.day10_iframe_switchingWindows;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_AyniWindowdaFarkliSayfalardaGezinme extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("Https://www.testotomasyonu.com");

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("Anasayfa Url : " + driver.getCurrentUrl());
        System.out.println("Anasayfa title : " + driver.getTitle());
        System.out.println("Anasayfa WHD : " + driver.getWindowHandle());
        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]"))
                .click();


        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("Electronics Url : " + driver.getCurrentUrl());
        System.out.println("Electronics title : " + driver.getTitle());
        System.out.println("Electronics WHD : " + driver.getWindowHandle());
        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("Ilk urun Url : " + driver.getCurrentUrl());
        System.out.println("Ilk urun title : " + driver.getTitle());
        System.out.println("Ilk urun WHD : " + driver.getWindowHandle());
        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // bestbuy sayfasina gidin
        driver.get("https://www.bestbuy.com");

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("bestbuy Url : " + driver.getCurrentUrl());
        System.out.println("bestbuy title : " + driver.getTitle());
        System.out.println("bestbuy WHD : " + driver.getWindowHandle());
        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

    }
}
