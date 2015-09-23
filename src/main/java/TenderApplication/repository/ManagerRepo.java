package TenderApplication.repository;

import TenderApplication.Domain.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface ManagerRepo  extends CrudRepository<Manager, Long> {
}
