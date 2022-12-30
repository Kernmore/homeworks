package academy.prog.reflection.task2;

import java.io.*;
import java.nio.file.Files;

@SaveTo(pathTo = "text.txt")
public class TextContainer {

    private final String text = "fine";

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
}


