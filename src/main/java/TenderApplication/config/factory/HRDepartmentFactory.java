package TenderApplication.config.factory;

import TenderApplication.Domain.HRDepartment;

/**
 * Created by student on 2015/08/06.
 */
public class HRDepartmentFactory {

    public static HRDepartment createHRDepartment( String cont ,String buildingFloor)
    {

       HRDepartment department = new HRDepartment
                .Builder(cont)
                .buildingLocation(buildingFloor)
                .build();

        return  department;
    }
}
