package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translator.WelcomeMsg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		// run the spring application (this class as main)
		SpringApplication.run(D387SampleCodeApplication.class, args);
		WelcomeMsg englishMsg = new WelcomeMsg(Locale.US);
		WelcomeMsg frenchMsg = new WelcomeMsg(Locale.CANADA_FRENCH);

		// create a new thread for all locales
		Thread englishMsgWelcome = new Thread(englishMsg);
		Thread frenchMsgWelcome = new Thread(frenchMsg);

		// give a thread name to each locale
		englishMsgWelcome.setName("Thread #1");
		frenchMsgWelcome.setName("Thread #2");

		// start all locale threads
		englishMsgWelcome.start();
		frenchMsgWelcome.start();
	}
}
