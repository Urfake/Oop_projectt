package org.example.Models;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.Models.Customer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoginAspect {
    @Before("org.example.Models.MyPointcuts.allAddMethods()")
    public void beforeGetAuditAdvice() {
        System.out.println("Попытка произвести операцию");
    }
    @Before("org.example.Models.MyPointcuts.allAddMethods()" )
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)
                joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());
        if (methodSignature.getName().equals("validate")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj : arg) {
                if (obj instanceof Customer){
                    Customer customer = (Customer) obj;
                    System.out.println(" Информация о клиенте: имя клиента -" + customer.getName() + ", Возраст - " + customer.getAge() + ", Желаемая работа - " + customer.getWork() + ", Опыт работы -" + customer.getExperience());
            }
        }
        System.out.println("beforeAddLoggingAdvice: логгирование попытки получить работу");
        System.out.println("----------------------------");
    }
    }
}