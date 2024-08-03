package ru.wenn.springcourse.models;

public class Person {
    private int id;

    private String FIO;

    private int yearOfBirth;

    public Person(){

    }

    public Person(int yearOfBirth, String FIO, int id) {
        this.id=id;
        this.yearOfBirth = yearOfBirth;
        this.FIO = FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
