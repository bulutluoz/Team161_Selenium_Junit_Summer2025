package tests.day12_actionsClass_FakerClass;

import com.sun.source.tree.PackageTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_FormDoldurma extends TestBase_Each {
    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstnameKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();


        driver.findElement(By.xpath("//*[@id='btn-submit-form']"))
                .click();
        ReusableMethods.bekle(3);


        //5- Kaydin olusturuldugunu test edin
        //   kayit olusturunca bizi login sayfasina yonlendiriyor
        //   ama account butonuna basinca giris yapildigini goruyoruz

        driver.findElement(By.xpath("//span[.='Account']"))
                .click();

        // logout butonunun gorunur olmasi ile test edelim
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        ReusableMethods.bekle(2);
    }
}
