package utils;

import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDataGenerator {

    static Faker faker = new Faker();

    static String dateString = faker.date().birthday(14, 99).toString();
    static SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    private static final Date birthDate;

    static {
        try {
            birthDate = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

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

    public static String getBirthdayDay() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(birthDate);
    }

    public static String getBirthdayMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return monthFormat.format(birthDate);
    }

    public static String getBirthdayYear() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(birthDate);
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