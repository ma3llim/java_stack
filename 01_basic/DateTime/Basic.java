package DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Basic {
    public static void main(String[] args){
        LocalDate date = LocalDate.now().plusDays(5).minusDays(5);
        LocalDateTime time = LocalDateTime.now();
        LocalDate date2 = LocalDate.now();

        System.out.println(date2);
    }
}
