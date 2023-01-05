package academy.prog.reflection.task3;

import academy.prog.reflection.task2.TextContainer;

import java.io.*;

public class Data {
    @Save
    public String name;
    @Save
    private String surName;
    private String nickname;
    @Save
    private int age;
    private int numberOfCars;
    @Save
    private TextContainer container;
//    @Save
//    private String[] array;

    public Data() {
    }

    public Data(String name, String surName, String nickname, int age, int numberOfCars, TextContainer container) {
        this.name = name;
        this.surName = surName;
        this.nickname = nickname;
        this.age = age;
        this.numberOfCars = numberOfCars;
        this.container = container;
//        this.array = array;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", numberOfCars=" + numberOfCars +
                ", container=" + container +
                '}';
    }


}


