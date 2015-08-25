package TenderApplication.repository;

import TenderApplication.Domain.HRDepartment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface HRDepartmentRepo extends CrudRepository<HRDepartment, Long> {
}
