package HW2;

import java.lang.reflect.Method;

public class StringMethodsReflection {
    public static void main(String[] args) {
        Method[] methods = String.class.getDeclaredMethods();

        System.out.println("Методы класса String:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
