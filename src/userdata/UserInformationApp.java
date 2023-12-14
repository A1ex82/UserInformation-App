package userdata;

import java.util.Scanner;

public class UserInformationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол), разделенные пробелом:");
        String inputData = scanner.nextLine();

        UserDataProcessor.processUserData(inputData);
    }
}

