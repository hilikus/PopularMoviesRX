package it.italiaonline.popularmoviesrx.model;

/**
 * Created by d7137 on 07/12/2016.
 */

public class Person {

    private String name;
    private int salary;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
