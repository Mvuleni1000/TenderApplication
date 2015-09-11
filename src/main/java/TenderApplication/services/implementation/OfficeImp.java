package TenderApplication.services.implementation;

import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;
import TenderApplication.repository.OfficeRepo;
import TenderApplication.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/26.
 */
@Service
public class OfficeImp implements OfficeService {

    @Autowired
    OfficeRepo repo;

    @Override
    public List<Office> getOffice() {
        List<Office> officeNo = new ArrayList<Office>();

        Iterable<Office>offices = repo.findAll();
        for(Office office: offices)
        {
            officeNo.add(office);
        }
        return  officeNo;
    }

    @Override
    public List<Department> getNumberDepartments(Long id) {
        return repo.findOne(id).getdepartments();
    }

    @Override
    public List<HRDepartment> getHRDepartments(Long id) {
        return repo.findOne(id).getHrDepNo();
    }
}
