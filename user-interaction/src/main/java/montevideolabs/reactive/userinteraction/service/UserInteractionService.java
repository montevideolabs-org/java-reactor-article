package montevideolabs.reactive.userinteraction.service;

import montevideolabs.reactive.userinteraction.models.UserInteraction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserInteractionService {
    Flux<UserInteraction> filterByDomElementType(String domElementType);
    Mono<UserInteraction> getUserMostRecentInteraction(UUID userUUID);
}
