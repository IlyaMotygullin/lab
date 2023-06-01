package ru.lern.lab.Db.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "group_student")
    private String group;
    @OneToMany(mappedBy = "idStudent")
    private List<Achievement> achievements;
}
