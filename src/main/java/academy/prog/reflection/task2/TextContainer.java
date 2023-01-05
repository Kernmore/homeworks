package academy.prog.reflection.task2;

import academy.prog.reflection.task3.Save;

import java.io.*;
import java.nio.file.Files;

@SaveTo(pathTo = "text.txt")
public class TextContainer {


    private final String text = "fine";
    private final String texter = "fff";
    private int test = 15;

    public TextContainer(){

    }

    @Saver
    public void save(String text, String path){
        File file = new File(path);
        try(PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.write(text);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "text='" + text + '\'' +
                ", texter='" + texter + '\'' +
                ", test=" + test +
                '}';
    }
}


