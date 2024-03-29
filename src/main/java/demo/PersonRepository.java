package demo;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
        List<Person> findByLastName(String lastName);

        Person findByUniqueID(String uniqueID);

    }
