package TenderApplication.services;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;


import java.util.List;

/**
 * Created by student on 2015/09/17.
 */
public interface DepartmentService  extends ServiceUser<Department,Long>{


    public List<Department> getDepartments();
    public List<Contracts>getContractor(Long id);

}
