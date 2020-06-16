package com.dawidciesielski;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        new Thread (()-> System.out.println("Print from Runnable")).start();

        Employee joe = new Employee("Joe Doe", 30);
        Employee david = new Employee("David Dibbs", 31);
        Employee joanna = new Employee("Joanna Seet", 24);
        Employee frank = new Employee("Frank Lin", 45);

        List<Employee> employees = new ArrayList<>();
        employees.add(joe);
        employees.add(david);
        employees.add(joanna);
        employees.add(frank);


//        for (Employee employee: employees) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//        Collections.sort(employees, (Employee employee1, Employee employee2)->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
//       UpperConcat uc = (s1, s2) -> {
//           String result = s1.toUpperCase() + s2.toUpperCase();
//           return result;
//       };
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1,s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething(){

        UpperConcat uc =(s1, s2) -> {
            System.out.println("Lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
//        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() +s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }
}