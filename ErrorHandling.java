package Project_7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class ErrorHandling {
    public static String getValidDate(Scanner read, String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date date = null;
        while (date == null) {
            System.out.print(prompt);
            String input = read.nextLine();
            try {
                date = dateFormat.parse(input);
            } catch (ParseException Invalid) {
                System.out.println("Invalid date format. Please enter the date in 'yyyy-MM-dd' format.");
            }
        }
        return dateFormat.format(date);
    }
}
