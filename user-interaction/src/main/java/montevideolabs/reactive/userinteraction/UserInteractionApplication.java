package montevideolabs.reactive.userinteraction;

import montevideolabs.reactive.userinteraction.models.DomElement;
import montevideolabs.reactive.userinteraction.service.UserInteractionService;
import montevideolabs.reactive.userinteraction.service.UserInteractionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserInteractionApplication {

	public static void main(String[] args) {
		UserInteractionService service = new UserInteractionServiceImpl();
		service.filterByDomElementType("button")
				.subscribe(ui -> System.out.println(ui.toString()));

		SpringApplication.run(UserInteractionApplication.class, args);
	}

}
