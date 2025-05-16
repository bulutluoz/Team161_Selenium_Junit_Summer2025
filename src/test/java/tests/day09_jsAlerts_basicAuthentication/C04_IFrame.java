package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_IFrame extends TestBase_Each {

    @Test
    public void iFrameTest(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        //   elektonicsProducts webelementini dogru locate etmemize ragmen
        //   webelementi kullanamadigimizi gorduk
        //   HTML kodlarini inceledigimizde
        //   kullanmak istedigimiz elektonicsProducts elementinin
        //   ana sayfaya gomulu olan baska bir HTML sayfasina ait oldugunu gorduk

        // Bu webelementi kullanabilmek icin
        // ONCE icinde oldugu iframe'i locate edip
        // o iframe'e gecis yapmaliyiz

        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElectronics);

        WebElement elektonicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));

        Assertions.assertTrue(elektonicsProducts.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgisayarElementi = driver.findElement(By.id("pictext1"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgisayarElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- ‘Here are some products’ yazisinin gorunur olduğunu test edin
        //   Aradigimiz yazi anasayfada
        //   Ancak biz 2.adimda Electronics products iFrame'ine gecis yaptik
        //   Anasayfadaki bir webelementi kullanmak istiyorsak
        //   ONCE gecis yaptigimiz paralel evrenden anasayfaya geri donmeliyiz

        // driver.switchTo().parentFrame();
        // birden fazla katman varsa bir ust katmana cikar

        driver.switchTo().defaultContent();
        // kac katman olursa olsun direkt en ustteki anasayfaya cikar
        // bu class'da tek katman oldugu icin, ikisi de kullanilabilir



        WebElement hereSomeyaziElementi = driver.findElement(By.xpath("//p[@class='desc']"));
        Assertions.assertTrue(hereSomeyaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
    }
}
