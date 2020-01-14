package tr.com.ing.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("tr.com.ing")
public class ObjectBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectBotApplication.class, args);
	}

}
