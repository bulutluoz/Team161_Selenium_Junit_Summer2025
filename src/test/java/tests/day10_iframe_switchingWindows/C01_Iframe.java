package tests.day10_iframe_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Iframe extends TestBase_Each {

    @Test
    public void iframeTest(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo()
                .frame(iframeElectronics);

        WebElement electronicsProductsElementi =
                driver.findElement(By.xpath("//h2[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgisayarElementi = driver.findElement(By.id("pictext1"));

        String expectedIsim = "DELL Core I3 11th Gen";
        String actualisim = dellBilgisayarElementi.getText();

        Assertions.assertEquals(expectedIsim,actualisim);

        //4- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // aranan yazi anasayfada, biz ise ele iframeElectronics ifarame'nin icindeyiz
        // o zaman oncelikle anasayfaya gecis yapmaliyiz
        driver.switchTo().defaultContent();

        String expectedYazi = "Here are some products.";

        WebElement yaziElementi = driver.findElement(By.xpath("//p[@class='desc']"));

        Assertions.assertEquals(expectedYazi,yaziElementi.getText());

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        //    fashion yazisi 2. iframe'in icinde oldugundan once o iframe'e gecis yapmaliyiz

        WebElement iframeFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //6- Fashion bolumundeki ilk urunu tiklayin
        //   ilk urunu tikladigimizda YENI BIR TAB'da urun aciliyor
        //   bu gorevi yapabilmek icin ONCE WINDOW'LAR ARASINDA NASIL GECIS YAPABILECEGIMIZI ogrenelim


        //   ve ilk urun isminde "Men Slim Fit" gectigini test edin

        ReusableMethods.bekle(2);
    }
}
