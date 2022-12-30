package academy.prog.reflection.task1;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface TestAnnotation {
    int param1();
    int param2();
}
