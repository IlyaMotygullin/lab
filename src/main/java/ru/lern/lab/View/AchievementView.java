package ru.lern.lab.View;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AchievementView {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String type;
    @JsonProperty
    private Long idUser;
}
