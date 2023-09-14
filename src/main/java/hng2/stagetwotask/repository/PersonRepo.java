package hng2.stagetwotask.repository;

import hng2.stagetwotask.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
