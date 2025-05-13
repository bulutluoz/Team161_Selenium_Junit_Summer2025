package tests.day06_jUnitFramework;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class C01_TestNotasyonu {

    /*
        Bir class'in run edilebilir olmasi icin
        bugune kadar MUTLAKA main method olmali demistik

        Gercekten de main method olmadan
        method'larin yaninda run tusu cikmiyor

        JUnit Framework'u ile gelen en buyuk promosyon
        @Test notasyonudur

        @Test notasyonu sayesinde
        her bir method, bagimsiz olarak calistirilabilir hale gelir

     */

    @Test
    public void test04(){
        System.out.println("Test4 calisti");
    }

    @Test // @Disabled
    public void test02(){
        System.out.println("Test2 calisti");
    }

    @Test
    public void test03(){
        System.out.println("Test3 calisti");
    }

}
