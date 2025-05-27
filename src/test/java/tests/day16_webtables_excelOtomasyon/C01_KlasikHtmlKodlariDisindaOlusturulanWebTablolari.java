package tests.day16_webtables_excelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlKodlariDisindaOlusturulanWebTablolari extends TestBase_Each {

    @Test
    public void test01(){
        //                  //*[@role='trow'][3]/*[@role='tdata'][2]

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari bir liste olarak yazdirin
        List<WebElement> baslikDataElementleriList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        List<String> baslikDatalariList = ReusableMethods.stringListeDonustur(baslikDataElementleriList);

        System.out.println(baslikDatalariList);
        // [Product Name, Category, Price, Actions]

        // sadece role='hrow' yaparsak tum baslik satirini tek bir element olarak getirir
        // ve yazdirirsak  " Product Name	Category	Price	Actions "

        //  3. 3.sutunun basligini yazdirin
        System.out.println(baslikDatalariList.get(2)); // Price


        //  4. Tablodaki tum datalari yazdirin
        // 1.yontem tum table'i tek bir webelement olarak locate edip yazdiralim
        WebElement tumTabloElementi = driver.findElement(By.xpath("//*[@class='table']"));
        System.out.println("TUm tablo tek element : \n" + tumTabloElementi.getText());

        // 2.yontem tablo body'sindeki datalar'in role attribute'unu kullanarak
        //           bir liste seklinde tum datalari alalim
        List<WebElement> dataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> dataList = ReusableMethods.stringListeDonustur(dataElementleriList);

        System.out.println("Liste olarak datalar : \n" + dataList);

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki hucre sayisi : " + dataList.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());
        //Tablodaki satir sayisi : 5

        //  7. Tablodaki sutun sayisini yazdirin
        //     Web tablolarinda sutun yapisi yoktur
        //     Bunun yerine herhangi bir satirdaki data sayisini bulabiliriz
        //     Biz ilk gorevde basliktaki datalari list olarak kaydetmistik, onu kullanalim
        System.out.println("Sutun sayisi : " + baslikDatalariList.size());
        // Sutun sayisi : 4

        //  8. Tablodaki 3.kolonu yazdirin
        //     Web tablolarinda sutun yapisi yoktur
        //     3.sutunu yazdirmak icin HER SATIRDAKI 3.datayi yazdirmaliyiz

        //  9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
    }
}
