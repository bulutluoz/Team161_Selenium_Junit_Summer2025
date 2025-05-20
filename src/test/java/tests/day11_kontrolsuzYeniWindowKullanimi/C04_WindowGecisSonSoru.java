package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_WindowGecisSonSoru extends TestBase_Each {
    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(3);

        // yeni bir tab acarak, wisequarter.com.tr adresine gidin
        driver.switchTo()
                .newWindow(WindowType.TAB)
                .get("https://www.wisequarter.com.tr");
        ReusableMethods.bekle(3);

        // bagimsiz yeni bir window acarak youtube sayfasina gidin
        driver.switchTo()
                .newWindow(WindowType.WINDOW)
                .get("https://www.youtube.com");
        ReusableMethods.bekle(3);
        // Reusable methods classindaki window degistirme method'unu kullanarak

        // testotomasyonu'nun acik oldugu window'a donun
        String hedefUrl = "https://www.testotomasyonu.com/";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(3);
        // wise quarter'in acik oldugu window'a donun
        hedefUrl = "https://wisequarter.com.tr/";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        // title'in Wise icerdigini test edin
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(3);

        // youtube'un acik oldugu window'a donun
        hedefUrl = "https://www.youtube.com";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        // url'in youtube icerdigini test edin
        expectedUrlIcerik = "youtube";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(3);


    }
}
