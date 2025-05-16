package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Dropdown extends TestBase_Each {

    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        ReusableMethods.bekle(1);
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");
        //4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");
        //5. Sign in tusuna basin,
        driver.findElement(By.name("submit"))
                .click();
        // back tusuna basarak sayfaya donun
        driver.navigate()
                .back();
        ReusableMethods.bekle(3);
        //6. Online banking menusunden
        driver.findElement(By.xpath("//strong[text()='Online Banking']"))
                .click();
        ReusableMethods.bekle(1);
        // Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link"))
                .click();
        ReusableMethods.bekle(2);
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[.='Purchase Foreign Currency']"))
                .click();
        //8. “Currency” drop down menusunden Eurozone’u secin
            // 1.adim
        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
            // 2.adim
        Select select = new Select(currencyDdm);
            // 3.adim
        select.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount"))
                .sendKeys("200");
        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));

        Assertions.assertFalse(usDollarRadioButton.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false"))
                .click();
        //12. “Calculate Costs” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();
        // sonra “purchase” butonuna basin
        driver.findElement(By.id("purchase_cash"))
                .click();
        ReusableMethods.bekle(2);
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        WebElement uyariYaziElementi = driver.findElement(By.id("alert_content"));

        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = uyariYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

    }
}
