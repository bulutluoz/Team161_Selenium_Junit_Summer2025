package tests.day16_webtables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel_ExceldenDataAlma {

    @Test
    public void test01() throws IOException {

        // ulkeler excel'indeki
        // sayfa1'in 1.satir 1.sutunundaki datayi yazdirin

        // excel ozel bir yapi oldugundan, sorudan da anlasilacagi uzere adim adim ilerlemeliyiz

        // 1.adim : excel dosyasina (Java ile) ulasalim
        String dosyaYolu = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 2.adim : excel dosyasindaki Sayfa1'e ulasalim
        //          excel ozel bir yapi oldugundan, sadece dosyaya ulasmak yetmez
        //          sayfadaki datalari excel gibi tutacak bir obje'ye ihtiyacimiz var
        //  Workbook workbook = new Workbook();
        // 'Workbook' is abstract; cannot be instantiated

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // workbook objesi bu class'da bizim olusturdugumuz bir obje
        // YANNNNII biz aslinda bu class'da islem yaparken
        // canli olarak excel ile bilgi alisverisi yapmiyoruz
        // 23.satirda olusturdugumuz fileInputStream ile bir defalik excel'deki tum bilgileri alip
        // 31.satirda bizim olusturdugumuz workbook objesine bu datalari yukluyoruz
        // YANNNIII biz 31.satirdan itibaren excel'in kendisi ile degil
        // excel'deki datalarla olusturdugumuz kopya workbook objesi ile calisacagiz

        Sheet      sayfa1         = workbook.getSheet(        "Sayfa1"         );
        //  bizim verdigimiz isim                     excel'deki hedef sayfa ismi

        // 3.adim : Sayfa1'deki 1.satira ulasalim
        //          satirNo index kullanir, yani 0'dan baslar
        //          1.satira ulasmak istiyorsak index olarak 0 yazmaliyiz
        Row satir1 = sayfa1.getRow(0);


        // 4.adim : 1.satirdaki 1 datayi yazdiralim
        //          dataNo index kullanir, yani 0'dan baslar
        //          satirdaki 1. dataya ulasmak istiyorsak index olarak 0 yazmaliyiz
        Cell ilkData = satir1.getCell(0);

        System.out.println(ilkData); // Ülke (İngilizce)


        // 2.satirdaki 3.datayi yazdirin
        // Her seferinde sayfa(Sheet) objesi, satir(Row) objesi ve hucre(Cell) objesi
        // olusturmak ZORUNDA DEGILIZ
        // workbook objesinden baslayarak hedef hucreye kadar adim adim ilerleyebiliriz

        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(2)); // Afganistan



    }
}
