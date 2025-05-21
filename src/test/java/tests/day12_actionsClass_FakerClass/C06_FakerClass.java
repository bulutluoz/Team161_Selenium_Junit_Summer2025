package tests.day12_actionsClass_FakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C06_FakerClass {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.internet().emailAddress());

        System.out.println(faker.internet().password());

        System.out.println(faker.gameOfThrones().house());
    }
}
