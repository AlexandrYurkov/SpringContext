package ru.otus.YurkovAleksandr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
            Service service = context.getBean(Service.class);
            service.run();
            int i = 1;
            while (i >= 0){
                i = service.printMenu();
            }
            System.out.println("Service disabled");
        } catch (Exception e) {
            System.out.print(e.getMessage() + "\n" + e.getStackTrace());
        }
    }
}