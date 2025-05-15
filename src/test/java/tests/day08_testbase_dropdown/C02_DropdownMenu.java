package tests.day08_testbase_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    // ● https://testotomasyonu.com/form adresine gidin.
    //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //4. Secilen değerleri konsolda yazdirin
    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void dropdownTesti(){

        // ● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
            // 1.adim : dropdown webelemntini locate edip kaydedelim
        WebElement gunDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // 2.adim : bir select objesi olusturalim, parametre olarak dropdown elemntini yazalim
        Select selectDay = new Select(gunDropdown);
            // 3.adim : select objesi ile istenen islemi yapin
        selectDay.selectByIndex(5);


        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
            // 1.adim
        WebElement ayDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
            // 2.adim
        Select selectAy = new Select(ayDropdown);
            // 3.adim
        selectAy.selectByValue("nisan");


        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
            // 1.adim
        WebElement yilDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
            // 2.adim
        Select selectYil = new Select(yilDropdown);
            // 3.adim
        selectYil.selectByVisibleText("1990");


        //4. Secilen değerleri konsolda yazdirin
        System.out.println(selectDay.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayMenusuTumOptionElementleri = selectAy.getOptions();

        // WebElement'lerden olusan bir listeyi direkt yazdiramayiz
        // for loop ile her bir elementi ele alip
        // webelemnt uzerindeki yaziyi, olusturacagimiz bir String Listeye ekleyelim


        List<String> optionMetinleriList = new ArrayList<>();

        for (WebElement eachElement :ayMenusuTumOptionElementleri){
            optionMetinleriList.add(eachElement.getText());
        }

        System.out.println(optionMetinleriList);
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]


        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedMenuBoyutu = 13;
        int actualMenuBoyutu = ayMenusuTumOptionElementleri.size();


        Assertions.assertEquals(expectedMenuBoyutu,actualMenuBoyutu);

        // ekstra gorev
        // gun dropdown menusundeki tum secenekleri bir liste olarak yazdirin
        List<WebElement> gunDropdownElementleriList = selectDay.getOptions();
        List<String> gunDropdownSecenekleriStringList =
                ReusableMethods.stringListeDonustur(gunDropdownElementleriList);

        System.out.println(gunDropdownSecenekleriStringList);
        // [Gün, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]


        // istersek tek satirda da yazdirabiliriz
        System.out.println(  ReusableMethods.stringListeDonustur(gunDropdownElementleriList) );
        // [Gün, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]

        ReusableMethods.bekle(3);

    }
}
