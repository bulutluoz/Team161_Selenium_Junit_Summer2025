package tests.day06_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeEach_AfterEach {
    /*
        Test method'larinin driver objesini sorunsuz kullanabilmesi icin
        oncelikle MUTLAKA setUp() calismalidir

        JUnit methodCall'a ihtiyac duymadan
        Test method'u icin gerekli on ayarlamalari yaptigimiz
        setUp() otomatik olarak calistirir

        Bunun icin @Before... notasyonlari kullanilir

            @BeforeEach : HER BIR test method'undan once calisir
                          ornegin 3 test method'u varsa
                          her test method'undan once calisacagi icin
                          setUp() method'unu 3 kere calistirir
            @BeforeAll  : tum method'lardan once calisir
                          ornegin 3 test method'u varsa
                          test method'larindan hicbiri calismadan
                          setUp() method'unu 1 kere calistirir

     */


    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("setup() calisti");
    }

    @AfterEach
    public void teardown(){
        driver.quit();
        System.out.println("teardown() calisti");
    }

    @Test
    public void testotomasyonuTesti(){
        // testotomasyonu sitesine gidin
        driver.get("https://testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "testotomasyonu";

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else {
            System.out.println("Testotomasyonu testi FAILED");
            throw new AssertionError("url testotomasyonu icermiyor");
        }

    }

    @Test
    public void wisequarterTest(){
        // wisequarter sitesine gidin
        driver.get("https://wisequarter.com");

        // title'in Wise Quarter icerdigini test edin

        String actualTitle = driver.getTitle();
        String expectedTitleIcerik = "Wise Quarter";

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter testi PASSED");
        } else {
            System.out.println("Wise Quarter testi FAILED");
            throw new AssertionError("Title Wise Quarter icermiyor");

        }

    }

    @Test
    public void youtubeTest(){
        // YouTube sitesine gidin
        driver.get("https://youtube.com");

        // title'in Youtube oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("YouTube testi PASSED");
        } else {
            System.out.println("YouTube testi FAILED");
            throw new AssertionError("Title Youtube degil");

        }

    }
}
