package org.example;

import org.example.Models.MyConfig;
import org.example.Models.Customer;
import org.example.Models.DIrector;
import org.example.Models.Manager;
import org.example.Models.Worker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new
                        AnnotationConfigApplicationContext(MyConfig.class);
        Customer customer = context.getBean("customer", Customer.class);
        Manager manager=context.getBean("manager",Manager.class);
        DIrector dIrector=context.getBean("director",DIrector.class);
        Worker worker =context.getBean("worker",Worker.class);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = in.next();
        System.out.println("Введите пароль");
        String password = in.next();
        if (login.equals(dIrector.getLogin()) && password.equals(dIrector.getPassword())){
            dIrector.addManager(new Manager());
        }
        else if (login.equals(manager.getLogin()) && password.equals(manager.getPassword()))
        {
            manager.addCustomer(new Customer("Свен", "Скрам-менеджер", 13, 25));
        }
        else if (login.equals(worker.getLogin()) && password.equals(worker.getPassword())){
            worker.findCustomer(new Customer("Карина", "Уборщица", 4, 100));
        }
        else
            System.out.println("Invalid values");

        context.close();
    }
}
