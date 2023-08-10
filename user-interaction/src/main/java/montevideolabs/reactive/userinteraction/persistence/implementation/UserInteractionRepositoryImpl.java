package montevideolabs.reactive.userinteraction.persistence.implementation;

import montevideolabs.reactive.userinteraction.models.UserInteraction;
import montevideolabs.reactive.userinteraction.persistence.interfaces.UserInteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.util.List;

public class UserInteractionRepositoryImpl implements UserInteractionRepository {
    @Autowired
    private List<UserInteraction> userInteractions;

    @Override
    public Flux<UserInteraction> getAllUserInteractions() {
        return Flux.fromIterable(userInteractions);
    }
}
