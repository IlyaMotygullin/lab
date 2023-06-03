package ru.lern.lab.Visual;

import org.springframework.stereotype.Component;
import ru.lern.lab.Service.AchievementService;
import ru.lern.lab.View.AchievementView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class FrameAddAchievement {
    private final AchievementService achievementService;


    public FrameAddAchievement(AchievementService achievementService,
                               FrameAddStudent frameAddStudent) {
        this.achievementService = achievementService;

    }

    public void addAchievement(GeneralFrame generalFrame){
        JFrame frame = new JFrame("Добавить достижение");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);

        AchievementView achievementView = new AchievementView();
        List<JComponent> components = new ArrayList<>();

        components.add(createPanelForAddStudent("Введите название достижения",achievementView));

        components.add(createPanelForAddStudent("Введите тип достижения",achievementView));

        components.add(createPanelForAddStudent("Введите айди студента",achievementView));

        JButton button = new JButton("Добавить достижение");
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(achievementView);
                achievementService.addAchievement(achievementView);
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
        button.addMouseListener(listener);
        components.add(button);

        components.add(FrameAddStudent.generateReverseButton(frame,generalFrame));
        GeneralFrame.generateContainer(frame,components);
        frame.setVisible(true);

    }
    private JPanel createPanelForAddStudent(String type, AchievementView achievement){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (type.equals("Введите название достижения")){
                    achievement.setName(e.getActionCommand());
                }
                else if (type.equals("Введите тип достижения")){
                    achievement.setType(e.getActionCommand());
                }
                else if (type.equals("Введите айди студента")){
                    achievement.setIdUser(Long.parseLong(e.getActionCommand()));
                }


            }
        };
        JPanel jPanel = new JPanel();
        JLabel label = new JLabel(type);

        JTextField textField = new JTextField(15);
        textField.addActionListener(actionListener);
        jPanel.add(label);
        jPanel.add(textField);
        return jPanel;
    }
}
