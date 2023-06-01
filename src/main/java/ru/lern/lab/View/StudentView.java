package ru.lern.lab.View;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class StudentView {
@JsonProperty
    private Long id;
@JsonProperty
    private String fio;
@JsonProperty
    private String group;
@JsonProperty
    private List<Long> achievements;

}
