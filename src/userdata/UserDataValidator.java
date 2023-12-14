package userdata;

public class UserDataValidator {

    public static void validateUserData(String[] data) {
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество параметров. Требуется 6 параметров.");
        }
    }
}

