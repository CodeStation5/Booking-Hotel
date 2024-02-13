package edu.wgu.d387_sample_code.translator;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMsg implements Runnable {
    // hold english or french local
    Locale locale;

    // get the local
    public WelcomeMsg(Locale locale) {
        this.locale = locale;
    }

    // returns the needed welcome message for the local
    public String getWelcomeMsg() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("translation", locale);
        return resourceBundle.getString("welcomeMsg");
    }

    // when the program is run, print out welcome message on the welcome screen
    // this will include the thread the message is run on
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getId() + " " + getWelcomeMsg());
        System.out.println("Thread: " + this.locale.getDisplayName() + " " + getWelcomeMsg());
    }
}
