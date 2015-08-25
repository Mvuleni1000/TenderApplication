package TenderApplication.repository;

import TenderApplication.Domain.Office;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface OfficeRepo extends CrudRepository<Office, Long> {
}
