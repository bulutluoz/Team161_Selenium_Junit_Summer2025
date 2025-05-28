package tests.day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {

        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek Sayfa1’e kadar gidelim
        String dosyaYolu = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //4) 1.satir 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        sayfa1.getRow(1).getCell(2).setCellValue("Naber???????");

        // ek gorev
        // 191.ulke olarak Javaland ekleyin, baskenti Malatya olsun

        int yeniSatirIndex = sayfa1.getLastRowNum()+1 ;
        sayfa1.createRow(yeniSatirIndex);
        // yeni satirda ulke ismi yazacagimiz hucreyi olusturup Javaland yazdiralim
        sayfa1.getRow(yeniSatirIndex)
                .createCell(0)
                .setCellValue("Javaland");

        sayfa1.getRow(yeniSatirIndex)
                .createCell(1)
                .setCellValue("Malatya");

        //9) Dosyayi kaydedelim
        //   Biz yaptigimiz degisiklikleri excel'e kaydetmeden once
        //   excel'in kapali oldugundan emin olmaliyiz

        //  fiziki excel'deki bilgileri ve sayfa yapisini
        //  dosyaYolu ve fileInputStream ile aldigimiz GIBI
        //  yaptigimiz degisiklikleri excel'e yollamak icin
        //  dosyaYolu ve FileOutputStream kullanmaliyiz

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);


        //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();




    }
}
