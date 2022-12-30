package academy.prog.reflection.task2;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Class<?> cls = TextContainer.class;
        SaveTo ann = cls.getAnnotation(SaveTo.class);

        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Saver.class)) {
                TextContainer t = new TextContainer();
                try {
                    m.invoke(t, t.getText(), ann.pathTo());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

