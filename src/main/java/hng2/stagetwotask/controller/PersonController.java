package hng2.stagetwotask.controller;

import hng2.stagetwotask.ApiResponse;
import hng2.stagetwotask.exceptions.UserNotFoundException;
import hng2.stagetwotask.repository.PersonRepo;
import hng2.stagetwotask.entity.Person;
import hng2.stagetwotask.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepo personRepo;

    @PostMapping
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {

//        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) throws UserNotFoundException {
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ApiResponse> updatePerson(@PathVariable Long id,
                                                    @RequestBody Person person) throws Exception {
        Optional<Person> optionalPerson = Optional.ofNullable(personService.getPerson(id));

        personService.updatePerson(person, id);
        return new ResponseEntity<>(new ApiResponse(id, person.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) throws UserNotFoundException {
        personService.deletePerson(id);
        return new ResponseEntity<>("Deleted user successfully " ,HttpStatus.OK);
    }
}
