package TenderApplication.services;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public interface UserSerivce {

    public List<Users>getUsers();
    public List<Company>getUserCompany(Long id);
}
