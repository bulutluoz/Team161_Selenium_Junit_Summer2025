package tests.day12_actionsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement acceptableElementi = driver.findElement(By.xpath("//*[@id='draggable2']"));

        WebElement dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));


        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableElementi,dropHereElementi)
                .perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi = "Dropped!";
        String actualyazi = dropHereElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableElementi = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));

        actions.dragAndDrop(notAcceptableElementi,dropHereElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi = "Drop Here";

        actualyazi = dropHereElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        ReusableMethods.bekle(2);
    }
}
