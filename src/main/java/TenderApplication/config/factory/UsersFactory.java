package TenderApplication.config.factory;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class UsersFactory {
    public static Users createUser(String account,String contactDetails,Address building_address,List<Company> company)
    {
        Users newUSer = new Users
                .Builder(contactDetails)
                .account(account)
                .address(building_address)
                .company(company)
                .build();

        return newUSer;
    }

}
