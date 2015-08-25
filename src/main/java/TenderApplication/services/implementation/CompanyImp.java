package TenderApplication.services.implementation;

import TenderApplication.Domain.Company;
import TenderApplication.repository.CompanyRepo;
import TenderApplication.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@Service
public class CompanyImp implements CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public List<Company> getCompany()
    {
        List<Company> companies = new ArrayList<Company>();

        Iterable<Company>companies1 = companyRepo.findAll();
        for(Company company: companies1)
        {
            companies.add(company);
        }
        return  companies;
    }
}
