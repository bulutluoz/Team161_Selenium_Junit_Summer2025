package tests.day18_sceenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_TarihliTumSayfaScreenshot extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // screenshot alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // screenshot alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);
        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // screenshot alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);

    }
}
