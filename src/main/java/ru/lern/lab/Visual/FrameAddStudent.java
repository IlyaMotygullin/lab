package ru.lern.lab.Visual;

import org.springframework.stereotype.Component;
import ru.lern.lab.Service.StudentService;
import ru.lern.lab.View.StudentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class FrameAddStudent {
    private final StudentService studentService;

    public FrameAddStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(GeneralFrame generalFrame){
        StudentView student = new StudentView();
        JFrame jFrame = new JFrame();
        JButton button = new JButton("Добавить пользователя");
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(student);
                studentService.addStudent(student);
                jFrame.dispose();
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
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800,600);
        List<JComponent> components = new ArrayList<>();
        components.add(createPanelForAddStudent("Введите Фамилию Имя Отчество",student));

        components.add(createPanelForAddStudent("Введите Группу",student));

        components.add(button);

       components.add(generateReverseButton(jFrame,generalFrame));
       GeneralFrame.generateContainer(jFrame,components);
        jFrame.setVisible(true);

    }
    private JPanel createPanelForAddStudent(String type, StudentView student){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (type.equals("Введите Фамилию Имя Отчество")){
                    student.setFio(e.getActionCommand());
                }
                else if (type.equals("Введите Группу")){
                    student.setGroup(e.getActionCommand());
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
    public static JButton generateReverseButton(JFrame frame,GeneralFrame generalFrame){
        JButton button = new JButton("Назад");
        MouseListener listener = new MouseListener() {
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
        button.addMouseListener(listener);
        return button;
    }
}
