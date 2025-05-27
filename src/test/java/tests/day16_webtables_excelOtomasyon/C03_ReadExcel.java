package tests.day16_webtables_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)

        //- 1.satirdaki 2.hucreyi bir string degiskene atayin
        String satir1Hucre2 = sayfa1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("satir1Hucre2 deki data: " + satir1Hucre2);
        // satir1Hucre2 deki data: Başkent (İngilizce)

        //  ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String expectedCellValue = "Başkent (İngilizce)";
        String actualCellValue = satir1Hucre2;

        Assertions.assertEquals(expectedCellValue,actualCellValue);

        //- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        expectedCellValue = "Kabil";
        actualCellValue = sayfa1.getRow(1)
                                .getCell(3)
                                .getStringCellValue();

        Assertions.assertEquals(expectedCellValue,actualCellValue);


        //- Ulke sayisinin 190 oldugunu test edin
        System.out.println(sayfa1.getLastRowNum()); // 190
        // index kullandigi icin satir sayisini bulmak istersek 1 eklemeliyiz 190+1 ==> 191 satir var

        int expectedUlkeSayisi = 190;
        int actualUlkeSayisi = sayfa1.getLastRowNum() + 1  -1 ;
        // +1 index sayisindan satir sayisini bulabilmek icin
        // -1 excel'deki ilk satir ulke ismi degil baslik

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);


        //- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        //- Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        //- Turkce baskent isimlerinde Ankara bulundugunu test edin



    }
}
