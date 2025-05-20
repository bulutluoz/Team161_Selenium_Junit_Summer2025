package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_MethodIleWindowGecisi extends TestBase_Each {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingANewWindowYaziElementi = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        Assertions.assertTrue(openingANewWindowYaziElementi.isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);


        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here"))
                .click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        // driver'i acilan 2.window'a gecirmeliyiz
        String hedefUrl = "https://the-internet.herokuapp.com/windows/new";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "New Window";
        String actualYazi = sayfadakiYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra
        // ilk window'a gecis yapalim
        hedefUrl = "https://the-internet.herokuapp.com/windows";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);


        // sayfa başlığının “The Internet” olduğunu test edin
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }
}
