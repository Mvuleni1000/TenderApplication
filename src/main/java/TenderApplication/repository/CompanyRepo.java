package TenderApplication.repository;

import TenderApplication.Domain.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface CompanyRepo extends CrudRepository<Company, Long> {
}
