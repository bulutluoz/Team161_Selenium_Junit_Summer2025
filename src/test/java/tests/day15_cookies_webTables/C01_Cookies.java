package tests.day15_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase_Each {
    @Test
    public void test01(){

        //1- google anasayfaya gidin
        driver.get("https://www.google.com");
        ReusableMethods.bekle(1);
        //2- cookies cikarsa kabul edin
        driver.findElement(By.xpath("//div[.='Accept all']"))
                .click();
        ReusableMethods.bekle(1);
        //3- Sayfadaki cookies sayisinin 3 veya daha fazla oldugunu test edin
        Set<Cookie> cookieSet = driver.manage().getCookies();

        int expectedMinCookieSayisi = 3;
        int actualCookieSayisi = cookieSet.size();

        Assertions.assertTrue(actualCookieSayisi >= expectedMinCookieSayisi);

        //4- sayfadaki cookie'leri yazdirin
        System.out.println(cookieSet);
        /*
            [
              NID=524=t1bO58MU7kxZyLG_S2WiJa08pylbVJvaa_wyM0jpPkifc8tK8afjmiT0SHL25-3FEFXfn_47MHydK2TR-5OW5xDv89efNDuCzMfRWNBWWEZfHdgALF4KP2xdKt8NcRI-BLjytudXO9Mzufx3x4jADKeb8QbuAfpAZsGkz6JVEiYOOHsLemyv3TlGHMPg4_iS3iyWQZGqNNJla7JMwfdaiaJnH0OzNypaFlMODU-aDcHN5xaSVQkUZEBtRjr4xK-Ho_-3vvyaEDI58CQ; expires=Sun, 23 Nov 2025 17:56:43 GMT; path=/; domain=.google.com;secure;; sameSite=None,
              SOCS=CAISHAgBEhJnd3NfMjAyNTA1MjItMF9SQzEaAmVuIAEaBgiAmMTBBg; expires=Tue, 23 Jun 2026 17:56:43 GMT; path=/; domain=.google.com;secure;; sameSite=Lax,
              EUULE=a+cm9sZTogMQpwcm9kdWNlcjogMTIKdGltZXN0YW1wOiAxNzQ4MTA5NDAyMDA2MDAwCmxhdGxuZyB7CiAgbGF0aXR1ZGVfZTc6IDUxNDc3NTAzMwogIGxvbmdpdHVkZV9lNzogNjE4MzkwNDkKfQpyYWRpdXM6IDIxNzAwCnByb3ZlbmFuY2U6IDEyCg==; expires=Sat, 24 May 2025 18:06:42 GMT; path=/; domain=www.google.com;secure;; sameSite=Lax,
              AEC=AVh_V2j5uXMNO8ij-zE-Gc5as4tCIq9L7A_1-tC2GZiWLkuMgR7ECNHn-Q; expires=Thu, 20 Nov 2025 17:56:41 GMT; path=/; domain=.google.com;secure;; sameSite=Lax]
         */

        // cookie'leri daha duzenli sekilde yazdirmak icin loop kullanalim
        // Set index desteklemedigi icin for-each loop kullanmaliyiz

        int siraNo =1;

        for (Cookie eachCookie : cookieSet){

            System.out.println(siraNo + ". cookie: \n" + eachCookie);
            siraNo++;
        }

        /*
            1. cookie:
            NID=524=ZLMlaOB7iJ0GG3Twhd13chFUehAQuzRdy-Qj6-YuW6PAMm2Bgf2CLZgJgJgruIHmjnWSxi6mvRWaKTrieu4Na1a-f-GVJV4_5-8cdK32eD8MYNlLi_hPna1V6Tl99ldNkHQFx_VttbbiMM5_cgDw-KiLMyKPqiDHn5kRW3c8nDu6rt538Cqzi-Q3WO9UcApnjdwiJm4hvOpsXoOzPHvrVVHN4T6HxzL3WFbTaw46F2MfVy-V1upd2PjA5dd4gxwm17dzpuj2dpI0PlQ; expires=Sun, 23 Nov 2025 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=None
            2. cookie:
            SOCS=CAISHAgBEhJnd3NfMjAyNTA1MjItMF9SQzEaAmVuIAEaBgiAmMTBBg; expires=Tue, 23 Jun 2026 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=Lax
            3. cookie:
            EUULE=a+cm9sZTogMQpwcm9kdWNlcjogMTIKdGltZXN0YW1wOiAxNzQ4MTA5NTk5MTU1MDAwCmxhdGxuZyB7CiAgbGF0aXR1ZGVfZTc6IDUxNDc3NTI2NwogIGxvbmdpdHVkZV9lNzogNjE4NDAxMTUKfQpyYWRpdXM6IDIxNzAwCnByb3ZlbmFuY2U6IDEyCg==; expires=Sat, 24 May 2025 18:09:59 GMT; path=/; domain=www.google.com;secure;; sameSite=Lax
            4. cookie:
            AEC=AVh_V2ix7byAspopZMhhcf5ODXS46SoEUS1nHUIExmBeROFLEYXSD5UN_Vc; expires=Thu, 20 Nov 2025 17:59:58 GMT; path=/; domain=.google.com;secure;; sameSite=Lax

         */

        //5- cookie'lerin isimlerini yazdirin
        siraNo =1;

        for (Cookie eachCookie : cookieSet){

            System.out.println(siraNo + ". cookie ismi : " + eachCookie.getName());
            siraNo++;
        }

//        1. cookie ismi : NID
//        2. cookie ismi : SOCS
//        3. cookie ismi : EUULE
//        4. cookie ismi : AEC


        //6- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookieObjesi = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookieObjesi);

        //7- eklediginiz cookie’nin sayfaya eklendigini test edin
        //   alternatif yontemler
        //   A- tum cookieleri kaydedip, cookie isimlerini olusturacagim bir listeye atip,
        //      liste "en sevdigim cookie" iceriyor mu diye test edebilirim
        //   B- "en sevdigim cookie" 'nin value'sunun "cikolatali" oldugunu test edebilirim

        // B-yontemi (NullPointerException riski var)
        Cookie actualCookie = driver.manage().getCookieNamed("en sevdigim cookie");
        String expectedCookieValue = "cikolatali";
        String actualCookieValue = actualCookie.getValue();

        Assertions.assertEquals(expectedCookieValue,actualCookieValue);

        // A yontemi
        cookieSet = driver.manage().getCookies();

        // tum cookie'lerin isimlerini olusturacagimiz bir listeye ekleyelim

        List<String> cookieIsimleriList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet){
            cookieIsimleriList.add(eachCookie.getName());
        }

        // listede en sevdigim cookie bulundugunu test edelim
        Assertions.assertTrue(cookieIsimleriList.contains("en sevdigim cookie"));



        //8- ismi SOCS olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("SOCS");

        cookieSet = driver.manage().getCookies();

        cookieIsimleriList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet){
            cookieIsimleriList.add(eachCookie.getName());
        }

        Assertions.assertFalse(cookieIsimleriList.contains("SOCS"));

        //9- tum cookie’leri silin
        driver.manage().deleteAllCookies();

        // ve silindigini test edin

        cookieSet = driver.manage().getCookies();

        Assertions.assertTrue(cookieSet.isEmpty());

    }
}
