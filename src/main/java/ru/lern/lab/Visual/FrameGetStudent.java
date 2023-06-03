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
        Container container = frame.getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        container.add(label,constraints);
        constraints.gridy++;

        if (studentView.getAchievements()!=null&&studentView.getAchievements().size()!=0){
            List<Long> achievementList = studentView.getAchievements();
            List<AchievementView> achievementViews = new ArrayList<>();
            for (Long achievement: achievementList) {
                achievementViews.add(achievementService.getAchievementById(achievement));
            }
            JList jList = new JList(achievementViews.toArray());
            container.add(jList,constraints);
            constraints.gridy++;
        }
        else {
            container.add(new JLabel("Достижений нет"), constraints);
            constraints.gridy++;
        }
        container.add(generateButton(frame,generalFrame),constraints);
        frame.setVisible(true);


    }
    private JButton generateButton(JFrame frame,GeneralFrame generalFrame){
        JButton button = new JButton("Назад ");
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                generalFrame.StartMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        button.addMouseListener(mouseListener);
return button;
    }
}
