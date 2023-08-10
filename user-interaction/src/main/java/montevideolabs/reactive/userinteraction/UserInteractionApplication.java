package montevideolabs.reactive.userinteraction;

import montevideolabs.reactive.userinteraction.config.ServiceConfiguration;
import montevideolabs.reactive.userinteraction.service.interfaces.UserInteractionService;
import montevideolabs.reactive.userinteraction.service.implementation.UserInteractionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class UserInteractionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInteractionApplication.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
		UserInteractionService userInteractionService = ctx.getBean(UserInteractionService.class);
		userInteractionService.filterByDomElementType("button")
			.subscribe(ui -> System.out.println(ui.toString()));
	}

}
