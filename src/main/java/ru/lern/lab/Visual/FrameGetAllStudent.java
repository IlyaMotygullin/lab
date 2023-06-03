package ru.lern.lab.Visual;

import org.springframework.stereotype.Component;
import ru.lern.lab.Service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Component
public class FrameGetAllStudent {
    private final StudentService studentService;

    public FrameGetAllStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    public void getAll(GeneralFrame generalFrame){
        JFrame frame = new JFrame("Список всех студентов");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        JList list = new JList(studentService.getAllStudent().toArray());
        frame.getContentPane().add(list);
        frame.getContentPane().add(new JScrollPane(list));

        frame.getContentPane().add(BorderLayout.SOUTH,FrameAddStudent.generateReverseButton(frame,generalFrame));
        frame.setVisible(true);

    }
}
