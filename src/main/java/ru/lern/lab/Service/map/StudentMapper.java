package ru.lern.lab.Service.map;

import org.springframework.stereotype.Service;
import ru.lern.lab.Db.Entity.Achievement;
import ru.lern.lab.Db.Entity.Student;
import ru.lern.lab.Db.Repository.AchievementRepository;
import ru.lern.lab.View.StudentView;

import java.util.stream.Collectors;

@Service
public class StudentMapper {
    private final AchievementRepository achievementRepository;

    public StudentMapper(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public Student mappedFromView(StudentView studentView){
        Student student = new Student();
        student.setId(studentView.getId());
        student.setFio(studentView.getFio());
        student.setGroup(studentView.getGroup());
        if (studentView.getAchievements()!=null){
        student.setAchievements(studentView.getAchievements().stream().
                map(achievementRepository::getReferenceById).collect(Collectors.toList()));
        }
        return student;
    }
    public StudentView mappedToView(Student student){
        StudentView studentView = new StudentView();
        studentView.setId(student.getId());
        studentView.setFio(student.getFio());
        studentView.setGroup(student.getGroup());
        studentView.setAchievements(student.getAchievements().stream()
                .map(Achievement::getId).collect(Collectors.toList()));
        return studentView;
    }
}
