package TenderApplication.config.factory;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class DepartmentFactory {

    public static Department createDepartment( String projects,String founder,  List<Contracts> contractID)
    {

        Department departments = new Department
                .Builder(projects)
                .foundedBy(founder)
                .contractID(contractID)
                .build();
        return departments;
    }
}
