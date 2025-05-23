package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitlyWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    @Test
    public void implicitlyWaitTest(){
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox= driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();
        // ve textbox etkin oluncaya kadar bekleyin

        ReusableMethods.bekle(4);

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        /*
            Implicitly wait'in 2 gorevi var
            1- sayfanin yuklenmesini beklemek
            2- herbir webelement'in locate edilebilir hale gelmesini beklemek

            testin bu adiminda
            sayfa zaten yuklu,
            textbox da locate edilebilir durumda
            dolayisiyla implicitly wait bu bekleme islemini YAPMAZ

            implicitly wait kullanamiyorsak
            2 ihtimal var
            1- bekleme suresi sabitse Thread.sleep() kullanilabilir
               ammaaa bu yontem dinamik olmadigi icin
               internetin durumuna gore bazen calisip bazen calismayabilir
               fazladan bekleme koymak bunun icin bir cozum olabilir
               bu durumda da gereksiz bekleme yapildigi icin
               testimiz efektif olmaz
            2- bu tur durumlarda
               webelement'e ve istedigimiz isleve OZEL
               explicit wait kulllanabiliriz

         */
        Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitWaitTest(){
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox= driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();

        // ve textbox etkin oluncaya kadar bekleyin
        /*
            Explicit Wait;
            implicitly wait'in cozum olmadigi durumlarda
            spesifik bir webelement (textbox)
            ve spesifik bir durum (etkin oluncaya kadar bekleme) icin olusturulur

            explicitwait olusturmak icin 3 adim atmamiz lazim
         */
        // 1.adim : webdriver wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        // 2.adim : kullanilacak webelement'i locate edin
        //          biz textbox'i zaten locate edip kaydettik

        // 3.adim : wait objesi ile spesifik webelement ve spesifik sebebinizi yazin
        //          spesifik sebebi Selenium tarafindan olusturulmus olan
        //          ExpectedConditions()'dan seceriz
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // hazir method'lar ile Selenium'a şunu dedik
        // "textbox clickable oluncaya kadar(maximum 20 sn) bekle"

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();

    }
}
