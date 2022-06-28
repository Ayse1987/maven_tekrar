package com.techpro;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Faker01 {
    @Test
    public void faker(){
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        System.out.println(firstName);
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.address().state());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());

    }

}
