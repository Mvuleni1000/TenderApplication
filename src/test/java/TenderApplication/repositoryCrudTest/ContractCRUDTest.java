package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.config.factory.ContractFactory;
import TenderApplication.repository.ContractRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by student on 2015/08/12.
 */
//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
public class ContractCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    ContractRepo repo;

  //  @Test
    public void create()throws Exception{

        Contracts contracts = ContractFactory.createContracts("Fishery_Documents","Agriculture_Dep");
        repo.save(contracts);
        id = contracts.getContractID();
        Assert.assertNotNull(id);
    }

   // @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Contracts hr = (Contracts)this.repo.findOne(this.id);
        Assert.assertNotNull(hr);
        Assert.assertEquals("Agriculture_Dep", hr.getDepName());
    }


    //@Test(dependsOnMethods = "read")
    public void update() {
        Contracts contracts = (Contracts)this.repo.findOne(this.id);
        Contracts newCon =  new Contracts.Builder(contracts.getDocuments()).copy(contracts).depName("Agriculture_Dep").build();
        this.repo.save(newCon);
        Contracts updateContractor = (Contracts)this.repo.findOne(this.id);
        Assert.assertEquals("Agriculture_Dep", updateContractor.getDepName());
    }

   // @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Contracts con = (Contracts)this.repo.findOne(this.id);
        this.repo.delete(con);
        Contracts contractor = (Contracts)this.repo.findOne(this.id);
        Assert.assertNull(contractor);
    }
}
