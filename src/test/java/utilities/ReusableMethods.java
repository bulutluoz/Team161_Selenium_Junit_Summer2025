package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
