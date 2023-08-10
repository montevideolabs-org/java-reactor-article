package montevideolabs.reactive.userinteraction.config;

import montevideolabs.reactive.userinteraction.models.DomElement;
import montevideolabs.reactive.userinteraction.models.UserInteraction;
import montevideolabs.reactive.userinteraction.persistence.implementation.UserInteractionRepositoryImpl;
import montevideolabs.reactive.userinteraction.persistence.interfaces.UserInteractionRepository;
import montevideolabs.reactive.userinteraction.service.interfaces.UserInteractionService;
import montevideolabs.reactive.userinteraction.service.implementation.UserInteractionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class ServiceConfiguration {

    @Bean
    public List<UserInteraction> userInteractions(){
        DomElement button = DomElement.builder()
                .withName("register-button")
                .withType("button")
                .build();
        DomElement contactUsLink = DomElement.builder()
                .withName("contact-us-link")
                .withType("href")
                .build();
        UserInteraction contactUsLinkHover = UserInteraction.builder()
                .withDomElement(contactUsLink)
                .withUserId(UUID.randomUUID())
                .withInteraction("hover")
                .withUnixTimestamp(System.currentTimeMillis() / 1000L)
                .build();
        UserInteraction contactUsLinkClick = UserInteraction.builder()
                .withDomElement(contactUsLink)
                .withUserId(UUID.randomUUID())
                .withInteraction("click")
                .withUnixTimestamp((System.currentTimeMillis() + 3000) / 1000L)
                .build();
        UserInteraction registerButtonClick = UserInteraction.builder()
                .withDomElement(button)
                .withUserId(UUID.randomUUID())
                .withInteraction("click")
                .withUnixTimestamp(System.currentTimeMillis() - 50000 / 1000L)
                .build();
        return List.of(contactUsLinkHover, contactUsLinkClick, registerButtonClick);
    }

    @Autowired
    @Bean
    public UserInteractionRepository userInteractionRepository(){
        return new UserInteractionRepositoryImpl();
    }

    @Bean
    public UserInteractionService userInteractionService(){
        return new UserInteractionServiceImpl();
    }
}
