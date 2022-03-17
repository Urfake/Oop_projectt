package org.example.Models;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* *(..))" )
    public void allAddMethods(){}
}
