package TenderApplication.services.implementation;

import TenderApplication.Domain.Manager;
import TenderApplication.repository.ManagerRepo;
import TenderApplication.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@Service
public class MangerImp implements ManagerService {


    @Autowired
    ManagerRepo managerRepo;

    @Override
    public List<Manager> getManager() {
        List<Manager> managers = new ArrayList<Manager>();

        Iterable<Manager> manager1 = managerRepo.findAll();
        for(Manager man: manager1)
        {
            managers.add(man);
        }
        return  managers;
    }
}
