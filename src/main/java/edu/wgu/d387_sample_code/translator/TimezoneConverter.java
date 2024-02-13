package edu.wgu.d387_sample_code.translator;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


// class to return 3 timezones to be printed
@CrossOrigin(origins = "http://localhost:4200")
public class TimezoneConverter {
    public static String getTimezone() {
        // format the date to hour:minute format. Seconds/date not needed
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        // store a future time for a scheduled presentation
        String timeMeet = "2024-01-28T10:30:00.000Z";
        // breaking the scheduled time into the hour:minute format
        ZonedDateTime dateTime = ZonedDateTime.parse(timeMeet);

        // storing UTC, EST and MST times of the meeting
        ZonedDateTime utcTime = dateTime.withZoneSameInstant(ZoneId.of("UTC"));
        ZonedDateTime estTime = dateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime mstTime = dateTime.withZoneSameInstant(ZoneId.of("America/Denver"));

        // storing the 3 timezones to be printed on the webpage
        String sendTime =
                  utcTime.format(timeFormat) + " UTC -- "
                + estTime.format(timeFormat) + " ET -- "
                + mstTime.format(timeFormat) + " MT.";
        return sendTime;
    }

}
