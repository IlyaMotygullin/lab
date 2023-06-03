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
        button.setSize(60,20);
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
        Container container = jFrame.getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        container.add(createPanelForAddStudent("Введите Фамилию Имя Отчество",student),constraints);
        constraints.gridy = 1;
        container.add(createPanelForAddStudent("Введите Группу",student),constraints);
        constraints.gridy=5;
        container.add(button,constraints);
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
}
