package tests.day17_excelAutomation_getScreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_MethodIleScreenshotCekme extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // screenshot alin
        ReusableMethods.tumSayfaResimCek(driver,"anasayfaTesti");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // screenshot alin
        ReusableMethods.tumSayfaResimCek(driver,"aramaTesti");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // screenshot alin
        ReusableMethods.tumSayfaResimCek(driver,"ilkUrunTesti");


    }
}
