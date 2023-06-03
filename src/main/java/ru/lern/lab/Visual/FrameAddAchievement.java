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

@Component
public class FrameAddAchievement {
    private final AchievementService achievementService;

    public FrameAddAchievement(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    public void addAchievement(GeneralFrame generalFrame){
        JFrame frame = new JFrame("Добавить достижение");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        Container container = frame.getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        AchievementView achievementView = new AchievementView();
        container.add(createPanelForAddStudent("Введите название достижения",achievementView),
                constraints);
        constraints.gridy = 1;
        container.add(createPanelForAddStudent("Введите тип достижения",achievementView),constraints);
        constraints.gridy=2;
        container.add(createPanelForAddStudent("Введите айди студента",achievementView),
                constraints);
        constraints.gridy=5;
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
        container.add(button,constraints);
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
