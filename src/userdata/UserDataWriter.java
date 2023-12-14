package userdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataWriter {

    public static void writeUserDataToFile(String lastName, String firstName, String middleName,
                                           Date birthDate, long phoneNumber, char gender) throws IOException {
        String fileName = lastName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(String.format("%s %s %s %s %d %s%n",
                    lastName, firstName, middleName,
                    new SimpleDateFormat("dd.MM.yyyy").format(birthDate), phoneNumber, gender));
        }
    }
}

