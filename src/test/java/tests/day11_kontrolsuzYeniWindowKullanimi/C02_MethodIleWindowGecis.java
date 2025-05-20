package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_MethodIleWindowGecis extends TestBase_Each {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products"))
                .click();



        /*
            Elimizde 2 tane window handle degeri var
            acik olan window'larin url/title 'larini biliyoruz

            https://testotomasyonu.com/category/7/products
            https://testotomasyonu.com/addremove/

            gecmek istedigimiz hedefUrl'i kaydedelim
            acikOlanTumWindowlarinWhdSeti'deki whd'lerini tek tek ziyaret edelim
            hangi whd'inde hedefurl'i bulursak orada kalalim

         */



        //● Electronics sayfasinin acildigini test edin
        // once driver'i electronics sayfasinin acik oldugu window'a gecirelim
        Set<String> acikOlanTumWindowlarinWhdSeti = driver.getWindowHandles();
        // [48BD373A035BCA71EA63B6DEFDB12323, 5B203BC8DD45CEE356B0F6870CCFF900]

        String hedefUrl = "https://testotomasyonu.com/category/7/products";

        for (String eachWhd :acikOlanTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            String actualUrl = driver.getCurrentUrl();

            if (hedefUrl.equals(actualUrl)){
                break;
            }

        }

        System.out.println("gectigimiz sayfanin url'i : " + driver.getCurrentUrl());
        //● Electronics sayfasinin acildigini test edin
        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//li[@class='current']"));
        String expectedYazi = "Electronics";
        String actualYazi = electronicsYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);



        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        hedefUrl = "https://testotomasyonu.com/addremove/";

        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));


        ReusableMethods.bekle(5);

    }
}
