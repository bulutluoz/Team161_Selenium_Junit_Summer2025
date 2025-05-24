package tests.day15_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_WebTables extends TestBase_Each {

    @Test
    public void klasikHtmlTabloTesti(){
        // EGER webTable klasik HTML kodlari ile olusturulmussa
        // SADECE tag'lari kullanarak
        // tum tabloyu, tum body'i, istedigimiz satiri veya istedigimiz hucreyi
        // kolayca locate edebiliriz

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println("Tum Body :   \n" + tumBodyElementi.getText());


        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String tumBody = tumBodyElementi.getText();

        Assertions.assertTrue(tumBody.contains(expectedTabloIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));

        /*
                [DELL Core I3 11th Gen
                8 GB/256 GB SSD/32 GB EMMC Storage/Ubuntu
                Electronics
                $399.00 Go,
                Samsung White Smart Watch
                Electronics
                $40.00 Go,
                Medium 25 L Laptop Backpack
                For Office/College/Travel (Black, Yellow)
                Travel
                $99.00 Go,
                Comfortable Gaming Chair
                Furniture
                $39.00 Go,
                Men Sun Glasses
                Men Fashion
                $15.00 Go]

         */

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        //   Web table satir ve satirdaki data mantigi ile calisir
        //   sutun(column) yapisi yoktur
        //   herhangi bir satirdaki data sayisi, bize tablonun sutun sayisini verir

        List<WebElement> ikinciSatirDataElementleriList = driver.findElements(By.xpath("//tr[2]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ikinciSatirDataElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tr[*]/td[3]"));

        System.out.println("Ucuncu sutun : " + ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));
        // Ucuncu sutun : [$399.00, $40.00, $99.00, $39.00, $15.00]

        //8. Tablodaki basliklari yazdirin
        WebElement baslikElementi = driver.findElement(By.tagName("thead"));
        System.out.println("Baslik satiri : " + baslikElementi.getText());
        // Baslik satiri : Produt Name Category Price Actions

        // eger basliklari ayri ayri gormek isterseniz
        // baslik satirindaki datalari bir liste olarak kaydedebiliriz

        List<WebElement> baslikElementleriList = driver.findElements(By.tagName("th"));

        System.out.println("Basliklar listesi : " + ReusableMethods.stringListeDonustur(baslikElementleriList) );
        // Basliklar listesi : [Produt Name, Category, Price, Actions]

        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        //   her web tablosunun yapisi birbirinden farkli olabilir
        //   boyle bir method'u butun web tablolari icin kullanamayiz
        //   Bundan dolayi resusable methods class'ina koyamayiz

        System.out.println(getCellData(2, 3)); // 	$40.00
        System.out.println(getCellData(3, 1)); // 	Medium 25 L Laptop Backpack


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        //    4.satir 2.sutun
        String actualData= getCellData(4,2);
        String expectedData = "Furniture";

        Assertions.assertEquals(expectedData,actualData);

    }

    public String getCellData(int satirNo, int sutunNo){

        //     //tr[    2    ]/td[   1    ]


        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();
    }
}
