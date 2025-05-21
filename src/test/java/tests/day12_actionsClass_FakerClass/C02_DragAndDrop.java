package tests.day12_actionsClass_FakerClass;

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

        //4- Sayfayi yenileyin

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        //6- “Drop Here” yazisinin degismedigini test edin

        ReusableMethods.bekle(10);
    }
}
