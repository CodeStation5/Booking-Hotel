package edu.wgu.d387_sample_code.translator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;

@RestController
@CrossOrigin (origins = "https://localhost:4200")
public class WelcomeMsgController {
    // map controller to the welcome html page
    @GetMapping("/welcome")
    public ResponseEntity<String> showWelcome(@RequestParam("lang") String localeLang) {
        // locale is made depending on the language it gets
        Locale locale = Locale.forLanguageTag(localeLang);
        // create the welcome message for the locale that was received
        WelcomeMsg msg = new WelcomeMsg(locale);
        // return locale message to be printed on welcome page with request succeeded (200 ok)
        return new ResponseEntity<>(msg.getWelcomeMsg(), HttpStatus.OK);
        //HttpStatus.Accepted

    }

}
