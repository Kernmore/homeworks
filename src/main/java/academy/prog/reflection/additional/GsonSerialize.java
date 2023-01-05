package academy.prog.reflection.additional;

import academy.prog.reflection.task3.Save;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class GsonSerialize<T> {
    private final File file = new File("save.txt");
    private Gson gson;
    public GsonSerialize() {
        gson = new GsonBuilder().create();
    }

    public T serializing(T obj, Class<?> cls) throws Exception {
        Field[] fields = cls.getDeclaredFields();
        Constructor<?> constr = cls.getConstructor();
        T newObj = (T) constr.newInstance();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                f.setAccessible(true);
                if (f.getType() == String.class || f.getType() == int.class || f.getType() == String[].class) {
                    f.set(newObj, f.get(obj));
                } else {
                    T subObj = serializing((T) f.get(obj), f.getType());
                    f.set(newObj, subObj);

                }
            }
        }
        return newObj;
    }

    public void saveTo(T newObj) throws IOException {
        FileWriter pw = new FileWriter(file);
        pw.write(gson.toJson(newObj));
        pw.close();
        System.out.println("Done");

    }

    public T getFrom() throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        Data newData2 = gson.fromJson(bf, Data.class);

        return (T) newData2;
    }

    public void run(T obj) throws Exception {
        Class<?> cls = obj.getClass();
        obj = serializing(obj, cls);
        saveTo(obj);
    }
}
