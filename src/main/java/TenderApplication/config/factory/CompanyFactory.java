package TenderApplication.config.factory;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Manager;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class CompanyFactory {

    public static Company createCompany(String name, String taxclarance, List<Manager> managerID)
    {
        Company newCompnay = new Company
                .Builder(name)
                .taxclarance(taxclarance)
                .managerID(managerID)
                .build();

        return newCompnay;
    }
}
