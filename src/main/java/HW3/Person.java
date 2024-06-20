package HW3;

import java.io.*;

public class Person implements Serializable {
    private final String name;
    private final int age;
    private final transient int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public static void serialazablePerson(Person person, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Person deserializePerson(String fileName) {
        Person person = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            person = (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

}
