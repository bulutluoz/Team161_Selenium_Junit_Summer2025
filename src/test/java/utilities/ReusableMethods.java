package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

}
