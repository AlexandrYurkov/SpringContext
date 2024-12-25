package ru.otus.YurkovAleksandr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.YurkovAleksandr.configApp.ConfigApp;
import ru.otus.YurkovAleksandr.impl.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
            ServiceImpl service = context.getBean(ServiceImpl.class);
            service.run();
            int i = 1;
            while (i >= 0){
                i = service.printMenu();
            }
            System.out.println("ServiceImpl disabled");
        } catch (Exception e) {
            System.out.print(e.getMessage() + "\n" + e.getStackTrace());
        }
    }
}