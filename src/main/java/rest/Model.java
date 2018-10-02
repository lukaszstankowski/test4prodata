package rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {

    @JsonProperty
    Long userId;

    @JsonProperty
    Long id;

    @JsonProperty
    String title;

    @JsonProperty
    String body;




}
