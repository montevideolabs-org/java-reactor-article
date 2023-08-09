package montevideolabs.reactive.userinteraction.models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder(setterPrefix = "with")
public class DomElement {
    private String name;
    private String type;
}
