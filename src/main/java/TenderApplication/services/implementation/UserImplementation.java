package TenderApplication.services.implementation;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;
import TenderApplication.repository.CompanyRepo;
import TenderApplication.repository.UserRepo;
import TenderApplication.services.UserSerivce;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@Service
public class UserImplementation implements UserSerivce {

    @Autowired
    UserRepo userRepo;



    @Override
    public Users findById(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public Users save(Users entity) {
        return userRepo.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return userRepo.save(entity);
    }

    @Override
    public void delete(Users entity) {
        userRepo.delete(entity);

    }

    @Override
    public List<Users> findAll() {
        return null;
    }


    @Override
    public List<Users> getUsers() {
        List<Users> userRegistered = new ArrayList<Users>();

        Iterable<Users>user = userRepo.findAll();
        for(Users user1: user)
        {
            userRegistered.add(user1);
        }
        return  userRegistered;
    }


    @Override
    public List<Company> getUserCompany(Long id) {
        return userRepo.findOne(id).getCompany();
    }
}
