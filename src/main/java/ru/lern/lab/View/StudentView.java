package ru.lern.lab.View;


import lombok.Data;

import java.util.List;
@Data
public class StudentView {

    private Long id;

    private String fio;

    private String group;

    private List<Long> achievements;

}
