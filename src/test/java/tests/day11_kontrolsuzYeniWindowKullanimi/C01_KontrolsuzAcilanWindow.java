package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Fashion bolumunde ilk urunu tiklayin
        //   Fashion bolumu bir iFrame icinde oldugundan, once o iFrame'e gecis yapmaliyiz
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);


        System.out.println("Ilk urunu tiklamadan once");
        System.out.println("Window handle : " + driver.getWindowHandle());
        System.out.println("Window handles : " + driver.getWindowHandles());

        // 1.adim tiklamadan once ilkWindowWhd'ini kaydedelim
        String ilkWindowWhd = driver.getWindowHandle();



        WebElement ilkUrun = driver.findElement(By.id("pic1_thumb"));
        ilkUrun.click();

        //3- acilan urun sayfasinda urun ismininin
        //   case sensitive olmadan dress icerdigini test edin


        System.out.println("Ilk urunu tikladiktan sonra");
        System.out.println("Window handle : " + driver.getWindowHandle());
        System.out.println("Window handles : " + driver.getWindowHandles());

        // 2.adim tikladiktan sonra eski ve yeni windowlarin
        //        WHD'lerini bir Set olarak kaydedelim

        Set<String> ikiWindowunWhdSeti = driver.getWindowHandles();


        // 3.adim : BULMACA
        //          Elimizde 1.ve 2. window'un Whd'lerinin oldugu bir Set
        //          bir de 1.window'un Whd'i var
        //          hedef Set'deki Whd'lerini elden gecirip
        //          1.window'un Whd'ine ESIT OLMAYANI 2.window'un Whd olarak kaydetmek
        //          Amac : 2.window'un window handle degerini bulup kaydetmek

        // for eeach loop ile aratip 1. whd'ine esit olmayani atama yapabiliriz

        String ikinciWindowWhd = "";

        for(String eachWhd:ikiWindowunWhdSeti){

            if (!eachWhd.equals(ilkWindowWhd)){
                ikinciWindowWhd = eachWhd;
            }

        }


        System.out.println("Bulmaca cozdukten sonra");
        System.out.println("1.window Whd : " + ilkWindowWhd);
        System.out.println("2.window Whd : " + ikinciWindowWhd);


        // Artik 2.window'a gecis cocuk oyuncagi, cunku Whd'ini biliyoruz

        driver.switchTo().window(ikinciWindowWhd);

        System.out.println(driver.getCurrentUrl());

        //3- acilan urun sayfasinda urun ismininin
        //   case sensitive olmadan shirt icerdigini test edin

        String expectedIsimIcerigi = "shirt";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualUrunIsmi = urunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

        //5- Ilk window’a donun ve Fashion yazisinin gorunur olduğunu test edin

        driver.switchTo().window(ilkWindowWhd);
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().frame(fashionIframe);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        ReusableMethods.bekle(3);
    }
}
