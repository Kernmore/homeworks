package academy.prog.reflection.task3;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class Serializaning<T> {
    private final File file = new File("serializable.txt");

    public void serialize(T t) throws IllegalAccessException, FileNotFoundException {
        Class<?> cls = t.getClass();
        Field[] fields = cls.getDeclaredFields();
        HashMap<String, String> hashMap = new HashMap<>();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                f.setAccessible(true);

                hashMap.put(f.getName(), f.get(t).toString());
                PrintWriter pw = new PrintWriter(file);
                hashMap.forEach((n, b) -> pw.write(n + "=" + b + "\n"));
                pw.close();

            }
        }
        System.out.println("Done, please check the file");
    }

    public T deserialize(T t) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        HashMap<String, String> map = (HashMap<String, String>) bf.lines()
                .collect(Collectors.toMap(getFunction(true), getFunction(false)));

        Class<?> cls = t.getClass();
        Field[] fields = cls.getDeclaredFields();

        setObjectFields(t, map, fields);

        return t;
    }

    private void setObjectFields(T t, HashMap<String, String> map, Field[] fields) throws Exception {
        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                f.setAccessible(true);
                if (map.containsKey(f.getName())) {
                    String obj = map.get(f.getName());
                    Class<?> type = f.getType();
                    int temp;
                    if (type == int.class) {
                        temp = Integer.parseInt(obj);
                        f.set(t, temp);
                    } else if (type == String.class) {
                        f.set(t, obj);
                    } else {
                        f.set(t, getObject(f, obj));
                    }
                }
            }
        }
    }

    private Function<String, String> getFunction(boolean b) {
        Function<String, String> getF;
        if (b) {
            getF = a -> {
                String[] split = a.split("=", 2);
                return split[0];
            };
        } else {
            getF = a -> {
                String[] split = a.split("=", 2);
                return split[1];
            };
        }
        return getF;
    }

    private T getObject(Field f, String obj) throws Exception {
        Class<?> aClass = f.getType();
        Constructor<?> constr = aClass.getConstructor();
        T newObj = (T) constr.newInstance();

        Field[] fields = aClass.getDeclaredFields();
        HashMap<String, String> map = getObjFields(obj);

        setObjectFields(newObj, map, fields);

        return newObj;

    }

    private HashMap<String, String> getObjFields(String obj) {
        String s = obj.substring(obj.indexOf("{"), obj.indexOf("}"));
        String[] strings = s.split(",");

        HashMap<String, String> map = (HashMap<String, String>) Arrays.stream(strings)
                .collect(Collectors.toMap(getFunction(true), getFunction(false)));
        return map;
    }
}
