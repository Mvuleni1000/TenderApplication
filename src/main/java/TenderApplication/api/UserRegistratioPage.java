package TenderApplication.api;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;
import TenderApplication.module.UserRegistrated;
import TenderApplication.services.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@RestController
@RequestMapping(value="/user/**")
public class UserRegistratioPage {

    @Autowired
    private UserSerivce serivce;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Company> getUserCompany(@PathVariable Long id) {return serivce.getUserCompany(id);}

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<UserRegistrated> getUsers()
    {

        List<UserRegistrated> hateoas = new ArrayList();
        List<Users> users = serivce.getUsers();


        for (Users c: users)
        {

            UserRegistrated res = new UserRegistrated.Builder(c.getContactDetails())
                    .account(c.getAccount())
                    .address(c.getBuilding_address())
                    .company(c.getCompany())
                    .build();

            Link sheet = new Link("http://localhost:8080/user" + res.getContactDetails()+res.toString())
                    .withRel("userRegistration");
            res.add(sheet);
            hateoas.add(res);
        }

        return hateoas;
    }

}
