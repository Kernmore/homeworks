package academy.prog.reflection.additional;

import academy.prog.reflection.task2.TextContainer;
import academy.prog.reflection.task3.Save;

import java.util.Arrays;

public class Data {
    @Save
    public String name;
    private String surName;
    @Save
    private String nickname;
    @Save
    private int age;
    private int numberOfCars;
    @Save
    private Person person;
    @Save
    private String[] array;

    public Data() {
    }

    public Data(String name, String surName, String nickname, int age, int numberOfCars, Person person, String[] array) {
        this.name = name;
        this.surName = surName;
        this.nickname = nickname;
        this.age = age;
        this.numberOfCars = numberOfCars;
        this.person = person;
        this.array = array;
    }


    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", numberOfCars=" + numberOfCars +
                ", person=" + person +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}


