package tests.day18_sceenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_JavascriptExecutor extends TestBase_Each {

    @Test
    public void test01() {

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // javascript executor ile isitme kaybi kismina kadar asagi inin
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement isitmeKaybiElementi = driver.findElement(By.id("hastalikCheck5"));

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",isitmeKaybiElementi);

        ReusableMethods.bekle(3);


        // isitme kaybi checkbox'ini click yapin

        jse.executeScript("arguments[0].click();",isitmeKaybiElementi);

        ReusableMethods.bekle(3);

        // alert ile "Yasasin JUnit bitti" yazdirin

        jse.executeScript("alert('Yasasin JUnit bitti');");

        ReusableMethods.bekle(3);

        // alert'i kapatin

        driver.switchTo()
                .alert()
                .accept();

        ReusableMethods.bekle(3);
    }
}
