package userdata;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataProcessor {

    public static void processUserData(String inputData) {
        try {
            String[] data = inputData.split(" ");

            UserDataValidator.validateUserData(data);

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            Date birthDate = parseDate(data[3]);
            long phoneNumber = parsePhoneNumber(data[4]);
            char gender = parseGender(data[5]);

            UserDataWriter.writeUserDataToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);

            System.out.println("Данные успешно обработаны и записаны в файл.");

        } catch (IllegalArgumentException | IOException | InvalidDateFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Date parseDate(String dateStr) throws InvalidDateFormatException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false); // Строгая проверка формата
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Неверный формат даты.");
        }
    }

    private static long parsePhoneNumber(String phoneNumberStr) {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона.");
        }
    }

    private static char parseGender(String genderStr) {
        if (genderStr.length() == 1 && (genderStr.charAt(0) == 'f' || genderStr.charAt(0) == 'm')) {
            return genderStr.charAt(0);
        } else {
            throw new IllegalArgumentException("Неверный формат пола. Используйте 'f' или 'm'.");
        }
    }
}

