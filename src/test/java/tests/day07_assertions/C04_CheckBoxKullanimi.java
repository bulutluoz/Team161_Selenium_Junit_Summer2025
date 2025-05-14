package tests.day07_assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxKullanimi {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    //	a. Verilen web sayfasına gidin.
    //	     https://testotomasyonu.com/form
    //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
    //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    //	d. Seker ve Epilepsi checkbox’larininin seçili
    //     olmadigini test edin

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));

        sirtAgrisiCheckbox.click();
        carpintiCheckbox.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckbox.isSelected(),"sirt agrisi secili degil");
        Assertions.assertTrue(carpintiCheckbox.isSelected(),"carpinti secili degil");

        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //     olmadigini test edin

        WebElement sekerCheckbox= driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox= driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckbox.isSelected(),"seker checkbox'i secili");
        Assertions.assertFalse(epilepsiCheckbox.isSelected(),"epilepsi checkbox'i secili");

    }

}
