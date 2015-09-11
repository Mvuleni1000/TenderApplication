package TenderApplication.services;

import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;

import java.util.List;

/**
 * Created by student on 2015/08/26.
 */
public interface OfficeService {

    public List<Office>getOffice();
    public List<Department>getNumberDepartments(Long id);
    public List<HRDepartment>getHRDepartments(Long id);
}
