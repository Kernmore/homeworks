package academy.prog.reflection.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {


    public static void main(String[] args) {

        Class<?> cls = Test.class;
        try {
            Method method = cls.getMethod("test", int.class, int.class);

            TestAnnotation ann = method.getAnnotation(TestAnnotation.class);
            method.invoke(new Test(), ann.param1(), ann.param2());

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    @TestAnnotation(param1 = 5, param2 = 6)
    public void test(int a, int b){
        System.out.println(a + b);
    }
}
