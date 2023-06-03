package ru.lern.lab.Visual;

import org.springframework.stereotype.Component;
import ru.lern.lab.Service.AchievementService;
import ru.lern.lab.Service.StudentService;
import ru.lern.lab.View.AchievementView;
import ru.lern.lab.View.StudentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class FrameGetStudent {
    private final StudentService studentService;
    private final AchievementService achievementService;

    public FrameGetStudent(StudentService studentService,
                           AchievementService achievementService) {
        this.studentService = studentService;
        this.achievementService = achievementService;
    }
    public  void getStudent(Long id,GeneralFrame generalFrame){
        StudentView studentView =studentService.getStudentById(id);
        JFrame frame = new JFrame("Информация о студенте с id " +id);
        frame.setSize(800,600);
        JLabel label = new JLabel(studentView.toString());
        List<JComponent> components = new ArrayList<>();
        components.add(label);


        if (studentView.getAchievements()!=null&&studentView.getAchievements().size()!=0){
            List<Long> achievementList = studentView.getAchievements();
            List<AchievementView> achievementViews = new ArrayList<>();
            for (Long achievement: achievementList) {
                achievementViews.add(achievementService.getAchievementById(achievement));
            }
            JList jList = new JList(achievementViews.toArray());
            components.add(jList);

        }
        else {
          components.add(new JLabel("Достижений нет"));

        }
       components.add(FrameAddStudent.generateReverseButton(frame,generalFrame));
        GeneralFrame.generateContainer(frame,components);
        frame.setVisible(true);


    }

}
