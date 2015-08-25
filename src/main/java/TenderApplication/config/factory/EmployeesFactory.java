package TenderApplication.config.factory;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Employees;

/**
 * Created by student on 2015/08/06.
 */
public class EmployeesFactory {


    public static Employees createEmployee( String firstname, String lastname, String contactDetails, Address building_address) {
        Employees employees1 = new Employees
                .Builder(firstname)
                .lastname(lastname)
                .contact(contactDetails)
                .address(building_address)
                .build();
        return employees1;
    }

}
