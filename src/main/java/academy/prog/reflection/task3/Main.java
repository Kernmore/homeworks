package academy.prog.reflection.task3;

import academy.prog.reflection.task2.TextContainer;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("Gleb", "Roker", "Surf", 25, 3, new TextContainer());

        Serializaning<Data> ser = new Serializaning<>();
        try {
            ser.serialize(data);
        } catch (IllegalAccessException | FileNotFoundException e) {
            e.printStackTrace();
        }

        Data newData = new Data();
        try {
            ser.deserialize(newData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(newData);
    }
}
