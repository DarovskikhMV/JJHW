package HW3;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class PersonService {
    private PersonRepository repository;

    public Person addPerson(Person person) {
        return (Person) repository.save(person);
    }
}


