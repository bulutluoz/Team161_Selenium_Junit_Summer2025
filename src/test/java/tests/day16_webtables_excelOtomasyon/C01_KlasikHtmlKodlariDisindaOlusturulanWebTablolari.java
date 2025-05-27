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
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow'][*]/*[@role='tdata'][3]"));

        List<String> ucuncuSutunDatalariList = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);

        System.out.println("3.Sutun : " + ucuncuSutunDatalariList);
        // 3.Sutun : [$399.00, $399.00, $399.00, $40.00, $15.00]


        //  9. Bir method olusturun, Test method'undan satir ve sutun verildiginde datayi dondursun
        System.out.println(getCellData(1,2)); // Electronics
        System.out.println(getCellData(4,1)); // Samsung White Smart Watch
        System.out.println(getCellData(3,3)); // $399.00


        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //     tum satirlari elden gecirip
        //     satirdaki category ( 2.data) Furniture ise
        //     satirdaki fiyati (3.data) yazdirmaliyiz

        int satirSayisi = satirElementleriList.size();

        for (int i = 1; i <=satirSayisi ; i++) {

            String satirdakiCategory = getCellData(i,2);
            String satirdakiFiyat = getCellData(i,3);

            if (satirdakiCategory.equalsIgnoreCase("Furniture")){
                System.out.println(satirdakiFiyat);
            }

        }

    }

    public String getCellData(int satirNo, int sutunNo){
      //              //*[@role='trow'][    3   ]/*[@role='tdata'][   2   ]

        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role='tdata'][" + sutunNo + "]";

        WebElement hedefCellElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefCellElementi.getText();

    }
}

