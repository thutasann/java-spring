package Basics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * Date Time Samples
 * @link - https://chamalwr.medium.com/datetime-api-in-java-2aef5df1c39b
 */
public class DateTimeSamples {
    public void SamplesOne() {
        System.out.println("\n==> Date Samples One");

        Date date = new Date();
        System.out.println("now date ==> " + date);

        System.out.println("Jan ==> " + Calendar.JANUARY);

        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);

        LocalTime thisTime = LocalTime.now();
        System.out.println("This time : " + thisTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Time : " + currentDateTime);

        LocalDate someDay = LocalDate.of(2020, Month.JUNE, 12);
        System.out.println("Someday : " + someDay);

        LocalTime someTime = LocalTime.of(23, 53);
        System.out.println("Sometime : " + someTime);

        LocalDateTime otherDateTime = LocalDateTime.of(2021, Month.MARCH, 4, 10,51,44);
        System.out.println("Other Date Time : " + otherDateTime);
    }
}
