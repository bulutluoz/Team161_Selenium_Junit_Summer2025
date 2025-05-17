package tests.day10_iframe_switchingWindows;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_KontrolluYeniWindowOlusturma extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url, title ve windowHandle degerlerini yazdirin
        System.out.println("anasayfa Url : " + driver.getCurrentUrl());
        System.out.println("anasayfa title : " + driver.getTitle());
        System.out.println("anasayfa WHD : " + driver.getWindowHandle());
        System.out.println("anasayfa acik tum WHD : " + driver.getWindowHandles());

        String birinciWindowWHD = driver.getWindowHandle();

        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // yeni bir tab acip
        driver.switchTo().newWindow(WindowType.TAB);
        String ikinciWindowWHD = driver.getWindowHandle();
        // yeni tab'da testotomasyonu.com sayfasindan
        // *** EGER kontrollu bir sekilde yeni window acarsaniz ***
        // driver otomatik olarak yeni acilan window'a gecer
        driver.get("https://www.testotomasyonu.com");

        // electronics linkini acin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]"))
                .click();
        System.out.println("electronics Url : " + driver.getCurrentUrl());
        System.out.println("electronics title : " + driver.getTitle());
        System.out.println("electronics WHD : " + driver.getWindowHandle());
        System.out.println("electronics acik tum WHD : " + driver.getWindowHandles());

        ReusableMethods.bekle(3);
        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        // yeni bagimsiz bir window acip
        driver.switchTo().newWindow(WindowType.WINDOW);
        String ucuncuWindowWHD = driver.getWindowHandle();

        // bestbuy anasayfaya gidin
        driver.get("https://www.bestbuy.com");

        System.out.println("bestbuy Url : " + driver.getCurrentUrl());
        System.out.println("bestbuy title : " + driver.getTitle());
        System.out.println("bestbuy WHD : " + driver.getWindowHandle());
        System.out.println("bestbuy acik tum WHD : " + driver.getWindowHandles());

        ReusableMethods.bekle(3);

        ReusableMethods.bekle(3);
        System.out.println("\n ================== \n");

        /*
            EGER verilen gorevde
            kontrollu olarak yeni window'lar aciliyor
            ve sonra eski acik olan window'lara gecmemiz isteniyorsa

         */

        // testotomasyonunun acik oldugu window'a gecis yapip
        driver.switchTo().window(birinciWindowWHD);

        // title'i yazdirin
        System.out.println("Yeniden testotomasyonu Title : " + driver.getTitle());
        // Yeniden testotomasyonu Title : Test Otomasyonu - Test Otomasyonu


        ReusableMethods.bekle(3);
        // electronics urunlerin acik oldugu window'a donun
        driver.switchTo().window(ikinciWindowWHD);

        // url'i yazdirin
        System.out.println(driver.getCurrentUrl());
        // https://www.testotomasyonu.com/category/7/products

        ReusableMethods.bekle(3);
    }
}
