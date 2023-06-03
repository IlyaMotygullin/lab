package ru.lern.lab.Visual;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
@Component
public class GeneralFrame {
    private final FrameGetAllStudent frameGetAllStudent;
    private final FrameAddStudent frameAddStudent;
    private final FrameAddAchievement frameAddAchievement;
    private final FrameGetStudent frameGetStudent;
    JFrame jFrame;

    public GeneralFrame(FrameGetAllStudent frameGetAllStudent,
                        FrameAddStudent frameAddStudent,
                        FrameAddAchievement frameAddAchievement,
                        FrameGetStudent frameGetStudent) {
        this.frameGetAllStudent = frameGetAllStudent;
        this.frameAddStudent = frameAddStudent;
        this.frameAddAchievement = frameAddAchievement;
        this.frameGetStudent = frameGetStudent;
    }

    public  void  StartMenu(){
        System.setProperty("java.awt.headless", "false");
        jFrame = new JFrame("student accounting");
        jFrame.setSize(800,480);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;
        container.add(generateButtons("список всех студентов"),constraints);
        constraints.gridy++;
        container.add(generateButtons("добавить студента"),constraints);
        constraints.gridy++;
        container.add(generateButtons("Добавить достижение"),constraints);
        constraints.gridy++;
        container.add(generatePanel(jFrame),constraints);
        jFrame.setVisible(true);


    }
    private JButton generateButtons(String type){
        JButton button = new JButton(type);
        GeneralFrame generalFrame = this;
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Кнопка нажата "  + type);
                jFrame.dispose();
                if(type.equals("список всех студентов")){

                    frameGetAllStudent.getAll(generalFrame);
                }
                else if (type.equals("добавить студента")){
                    frameAddStudent.addStudent(generalFrame);
                }
                else if (type.equals("Добавить достижение")){
                    frameAddAchievement.addAchievement(generalFrame);
                }
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
    private JPanel generatePanel(JFrame frame){
        final Long[] id = new Long[1];
        GeneralFrame generalFrame = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id[0] = Long.parseLong(e.getActionCommand());
                System.out.println(" Айди пришел " + id[0]);
                frame.dispose();
                System.out.println("айди отправляется " + id[0]);
                ;
                frameGetStudent.getStudent(id[0],generalFrame);
            }
        };
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Введите айди студента");
        JTextField field = new JTextField(10);
        field.addActionListener(listener);
        panel.add(label);
        panel.add(field);
        return panel;
    }
}
