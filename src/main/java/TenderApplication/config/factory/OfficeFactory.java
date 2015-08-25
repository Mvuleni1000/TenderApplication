package TenderApplication.config.factory;

import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class OfficeFactory {

    public static Office createAdim (String document, String station ,List<Department> departments, List<HRDepartment> hrDepNo)
    {
        Office adim = new Office
                .Builder(document)
                .station(station)
                .departments(departments)
                .hrDep(hrDepNo)
                .build();

        return adim;
    }
}
