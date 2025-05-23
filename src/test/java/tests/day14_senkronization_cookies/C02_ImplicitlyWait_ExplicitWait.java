package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ImplicitlyWait_ExplicitWait {

    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Remove butonuna basin.
    //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //4. Add buttonuna basin
    //5. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest() {
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
            remove butonuna basar basmaz
            itsGoneElementi'ni locate ediyoruz

            Aslinda itsGoneElementi 3 saniye sonra geliyor
            ama olmayan bir webelement'in locate edilebilmesi icin bekleme gorevi
            implicitly wait'in gorev alanina girdigi icin
            implicitly wait bekleme islemini hallediyor

         */
        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));

        Assertions.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }


    @Test
    public void explicitWaitTest() {
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // explicit wait, implicitlyWait'in yeterli olmadigi durumlarda kullanilir
        // implicitly wait'in bekleme suresini bilerek azalttik


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // explicit wait icin 3 adima ihtiyac var
        /*
            EGER
            webelementi locate edebilmek icin
            beklememiz gerekiyorsa
            o zaman 2. ve 3.adimi birlestiriyoruz
         */


        // 1.adim : webdriver wait objesi olusturmak
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        // 2.adim : kullanilacak webelement'i locate edip kaydedelim
        // 3.adim : spesifik webelement ve spesifik gorev icin wait objesi ile bekleme yapin

        // WebElement itsGoneElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));
        Assertions.assertTrue(itsGoneElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin
        //   It’s back mesajinin gorunur olmasi icin yine explicit wait kullanmaliyiz
        //   yeniden wait objesi olusturmaya gerek yok
        //   ama 2. ve 3.adimlari birlestirerek yazmamiz gerekiyor

        // WebElement itsBackElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));

        Assertions.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();

    }



}
