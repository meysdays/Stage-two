package hng2.stagetwotask.service;

import hng2.stagetwotask.exceptions.UserNotFoundException;
import hng2.stagetwotask.repository.PersonRepo;
import hng2.stagetwotask.entity.Person;
import hng2.stagetwotask.exceptions.CustomExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public Person createPerson(Person person) {

        return personRepo.save(person);
    }

    public Person getPerson(Long id) throws UserNotFoundException {
       Optional<Person> optional =  personRepo.findById(id);
       if (optional.isEmpty()) {
           throw new UserNotFoundException("User does not exist: " + id);
       }
        return optional.get();
    }

    public void updatePerson(Person person, Long id) throws  Exception {
        Optional<Person> optionalPerson = personRepo.findById(id);

        if (!optionalPerson.isPresent()){
            throw new Exception("person is not present");
        }
        Person person1 = optionalPerson.get();
        person1.setName(person.getName());
        personRepo.save(person1);
    }

    public void deletePerson(Long id) throws UserNotFoundException {
        Optional<Person> optionalPerson = personRepo.findById(id);

        if (optionalPerson.isEmpty()){
            throw new UserNotFoundException("User id is invalid");
        }

        personRepo.deleteById(id);
    }
}
