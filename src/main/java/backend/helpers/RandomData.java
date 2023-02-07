package backend.helpers;

import com.github.javafaker.Faker;

public class RandomData {
    public static class RandomDataCreateNewPet {
        public static Integer setLongId() {
            Faker faker = new Faker();
            return faker.number().numberBetween(7000, 9500);
        }

        public static String setDogName() {
            Faker faker = new Faker();
            return faker.name().firstName();
        }

        public static String setUrl() {
            Faker faker = new Faker();
            return faker.internet().url();
        }


    }

}

