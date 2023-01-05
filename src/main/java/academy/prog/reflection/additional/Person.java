package academy.prog.reflection.additional;

import academy.prog.reflection.task3.Save;

public class Person {

    @Save
    private String text;
    private String spam;
    @Save
    private int ID;


    public Person(String text, int ID, String spam) {
        this.text = text;
        this.ID = ID;
        this.spam = spam;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "text='" + text + '\'' +
                ", spam='" + spam + '\'' +
                ", ID=" + ID +
                '}';
    }
}
