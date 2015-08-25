package TenderApplication.repository;

import TenderApplication.Domain.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface DepartmentRepo extends CrudRepository<Department, Long> {
}
