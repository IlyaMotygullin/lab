package ru.lern.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lern.lab.Visual.GeneralFrame;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LabApplication.class,args);
        GeneralFrame generalFrame =context.getBean(GeneralFrame.class);
        generalFrame.StartMenu();
    }

}
