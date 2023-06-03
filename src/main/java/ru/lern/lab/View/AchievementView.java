package ru.lern.lab.View;

import lombok.Data;

@Data
public class AchievementView {

    private Long id;

    private String name;

    private String type;

    private Long idUser;
}
