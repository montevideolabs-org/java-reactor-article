package montevideolabs.reactive.userinteraction.service.implementation;

import montevideolabs.reactive.userinteraction.models.DomElement;
import montevideolabs.reactive.userinteraction.models.UserInteraction;
import montevideolabs.reactive.userinteraction.persistence.interfaces.UserInteractionRepository;
import montevideolabs.reactive.userinteraction.service.interfaces.UserInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class UserInteractionServiceImpl implements UserInteractionService {
    @Autowired
    private UserInteractionRepository userInteractionRepository;

    @Override
    public Flux<UserInteraction> filterByDomElementType(String domElementType) {
        Flux<UserInteraction> userInteractions = userInteractionRepository.getAllUserInteractions();
        return userInteractions
                .filter(ui -> ui.getDomElement().getType().equalsIgnoreCase(domElementType));
    }

    @Override
    public Mono<UserInteraction> getUserMostRecentInteraction(UUID userUUID) {
        Flux<UserInteraction> userInteractions = userInteractionRepository.getAllUserInteractions();
        userInteractions.subscribe(ui -> System.out.println(ui.toString()));
        return userInteractions
                .filter(ui -> ui.getUserId().equals(userUUID))
                .reduce((ui1, ui2) -> ui1.getUnixTimestamp() > ui2.getUnixTimestamp() ? ui1 : ui2);
    }
}
