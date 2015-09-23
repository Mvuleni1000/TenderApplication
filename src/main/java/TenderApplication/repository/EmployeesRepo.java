package TenderApplication.repository;

import TenderApplication.Domain.Employees;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface EmployeesRepo extends CrudRepository<Employees, Long> {
}
