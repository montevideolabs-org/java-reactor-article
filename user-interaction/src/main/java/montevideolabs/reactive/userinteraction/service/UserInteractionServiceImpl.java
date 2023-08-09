package montevideolabs.reactive.userinteraction.service;

import montevideolabs.reactive.userinteraction.models.DomElement;
import montevideolabs.reactive.userinteraction.models.UserInteraction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class UserInteractionServiceImpl implements UserInteractionService{
    private List<UserInteraction> supplyData(){
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
    @Override
    public Flux<UserInteraction> filterByDomElementType(String domElementType) {
        Flux<UserInteraction> userInteractions = Flux.fromIterable(this.supplyData());
        return userInteractions
                .filter(ui -> ui.getDomElement().getType().equalsIgnoreCase(domElementType));
    }

    @Override
    public Mono<UserInteraction> getUserMostRecentInteraction(UUID userUUID) {
        Flux<UserInteraction> userInteractions = Flux.fromIterable(this.supplyData());
        userInteractions.subscribe(ui -> System.out.println(ui.toString()));
        return userInteractions
                .filter(ui -> ui.getUserId().equals(userUUID))
                .reduce((ui1, ui2) -> ui1.getUnixTimestamp() > ui2.getUnixTimestamp() ? ui1 : ui2);
    }
}
