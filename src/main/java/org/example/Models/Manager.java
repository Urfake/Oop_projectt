package org.example.Models;

import org.springframework.stereotype.Component;

@Component("manager")
public class Manager {
    String name;
    String login = "manager";
    String password = "manager";
    int age;

    public Manager() {
    }

    public void addCustomer(Customer customer){
        System.out.println("Проверка работника на работоспособность");
    }
    public void success(){
        System.out.println("Принятие на работу");
    }
    public void deleteCustomer(){
        System.out.println("Неудачный кадр для работы");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
