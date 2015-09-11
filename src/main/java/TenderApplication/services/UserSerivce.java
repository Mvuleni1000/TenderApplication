package TenderApplication.services;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public interface UserSerivce extends ServiceUser<Users,Long> {

    public List<Users>getUsers();
    public List<Company>getUserCompany(Long id);

}
