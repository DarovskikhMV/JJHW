package HW3;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Artem", 20, 30000);
        Person person2 = new Person("Vasiliy", 30, 40000);
        Person person3 = new Person("Viktor", 42, 45000);

        Person.serialazablePerson(person1, "person1.bin");
        Person.serialazablePerson(person2, "person2.bin");
        Person.serialazablePerson(person3, "person3.bin");

        Person deserializedPerson1 = Person.deserializePerson("person1.bin");
        Person deserializedPerson2 = Person.deserializePerson("person2.bin");
        Person deserializedPerson3 = Person.deserializePerson("person3.bin");

        System.out.println("Десериализованный объект person1: " + deserializedPerson1.getName() +
                " возвраст-" + deserializedPerson1.getAge() + " зарплата-" + deserializedPerson1.getSalary());
        System.out.println("Десериализованный объект person2: " + deserializedPerson2.getName() +
                " возвраст-" + deserializedPerson2.getAge() + " зарплата-" + deserializedPerson2.getSalary());
        System.out.println("Десериализованный объект person1: " + deserializedPerson3.getName() +
                " возвраст-" + deserializedPerson3.getAge() + " зарплата-" + deserializedPerson3.getSalary());
    }
}
