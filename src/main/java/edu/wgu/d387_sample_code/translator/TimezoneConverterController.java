package edu.wgu.d387_sample_code.translator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// controller to return timezones and presentation message
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimezoneConverterController {
    @GetMapping("/timezone")
    public ResponseEntity<String> showTime() {
        // gets the timezone message and returns it combined with presentation message
        String sendMeeting = TimezoneConverter.getTimezone();
        return new ResponseEntity<>(sendMeeting, HttpStatus.OK);
    }
}
