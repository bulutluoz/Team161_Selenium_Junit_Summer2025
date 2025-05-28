package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye)  {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // verilen Webelement'lerden olusan bir listedeki
    // herbir webelement'i ele alip
    // web element uzerindeki yaziyi, olusturacagimiz bir listeye ekleyip,
    // tum elementler elden gectikten sonra
    // String'lerden olusan listeyi DONDUREN bir method olusturun

    public static List<String> stringListeDonustur (List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement:webElementList){
            stringList.add(eachElement.getText());

        }

        return stringList;

    }

    public static void urlIleWindowGecisi(WebDriver driver, String hedefUrl){

        Set<String> acikOlanTumWindowlarinWhdSeti = driver.getWindowHandles();

        for (String eachWhd :acikOlanTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            String actualUrl = driver.getCurrentUrl();

            if (hedefUrl.equals(actualUrl)){
                break;
            }

        }
    }

    public static void titleIleWindowGecisi(WebDriver driver, String hedefTitle){

        Set<String> acikOlanTumWindowlarinWhdSeti = driver.getWindowHandles();

        for (String eachWhd :acikOlanTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            String actualTitle = driver.getTitle();

            if (hedefTitle.equals(actualTitle)){
                break;
            }

        }
    }

    public static void tumSayfaResimCek(WebDriver driver){
        // 1.adim : TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
        File file = new File("target/screenshots/tumSayfaScreenshot.jpg");

        // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
