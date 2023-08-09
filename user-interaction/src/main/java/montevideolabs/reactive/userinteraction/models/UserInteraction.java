package montevideolabs.reactive.userinteraction.models;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder(setterPrefix = "with")
public class UserInteraction {
    private DomElement domElement;
    private UUID userId;
    private String interaction;
    private long unixTimestamp;
}
