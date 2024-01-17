package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {

    Report findByUniqueID(String uniqueID);

    List<Report> findBypersonSanityCardNumber(String personSanityCardNumber);
}
