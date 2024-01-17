package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRepository extends CrudRepository<Drug, Long> {

    List<Drug> findByPersonSanitNumber(String personSanitNumber);

    Drug findByUniqueID(String uniqueID);
}
