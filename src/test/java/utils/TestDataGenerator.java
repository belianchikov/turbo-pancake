package utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return faker.options().option(
                "Male",
                "Female",
                "Other"
        );
    }

    public static String getUserNumber() {
        return faker.number().digits(10);
    }

    public static String getBirthdayDay(String month) {
        return switch (month) {
            case "February" -> String.format("%02d", faker.number().numberBetween(1, 29));
            case "April", "June", "September", "November" -> String.format("%02d", faker.number().numberBetween(1, 31));
            default -> String.format("%02d", faker.number().numberBetween(1, 32));
        };
    }

    public static String getBirthdayMonth() {
        return faker.options().option(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
    }

    public static String getBirthdayYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2024));
    }

    public static String getSubject() {
        return faker.options().option(
                "Maths",
                "Arts",
                "English",
                "Biology",
                "History",
                "Computer Science"
        );
    }

    public static String getHobby() {
        return faker.options().option(
                "Sports",
                "Reading",
                "Music"
        );
    }

    public static String getPictureName() {
        return faker.options().option(
                "picture.png",
                "picture2.png",
                "picture3.png"
        );
    }

    public static String getCurrentAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        return faker.options().option(
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        );
    }

    public static String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }
}