package TenderApplication.services.implementation;
import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.repository.DepartmentRepo;
import TenderApplication.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/17.
 */
@Service
public class DeparmentImpl implements DepartmentService{


    @Autowired
    DepartmentRepo departmentRepo;

    private Long id;

    @Override
    public Department findById(Long id) {
        return departmentRepo.findOne(id);
    }

    @Override
    public Department save(Department entity) {
        return departmentRepo.save(entity);
    }

    @Override
    public Department update(Department entity) {
        return departmentRepo.save(entity);
    }

    @Override
    public void delete(Department entity) {
        departmentRepo.delete(entity);

    }

    @Override
    public List<Department> findAll() {
        return null;
    }


    @Override
    public List<Department> getDepartments() {
        List<Department> exisitngDepartments = new ArrayList<Department>();

        Iterable<Department>user = departmentRepo.findAll();
        for(Department user1: user)
        {
            exisitngDepartments.add(user1);
        }
        return  exisitngDepartments;
    }

    @Override
    public List<Contracts> getContractor(Long id) {
        return departmentRepo.findOne(id).getContractID();
    }
}
