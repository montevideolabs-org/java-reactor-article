package montevideolabs.reactive.userinteraction.persistence.interfaces;

import montevideolabs.reactive.userinteraction.models.UserInteraction;
import reactor.core.publisher.Flux;

public interface UserInteractionRepository {
    Flux<UserInteraction> getAllUserInteractions();
}
