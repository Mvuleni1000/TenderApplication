package TenderApplication.DomainTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.config.factory.ContractFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/08/06.
 */
public class ContractorTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testName() throws Exception {

        Contracts contracts = ContractFactory.createContracts( "Employees Domain", "Engineering");

        Assert.assertEquals("Engineering", contracts.getDepName());
    }

    @Test
    public void testUpdate() throws Exception {
        Contracts contracts = ContractFactory.createContracts("Employees Domain", "Agriculture");
        Assert.assertNotNull("Agriculture",  contracts.getDepName());
    }

    @After
    public void tearDown() throws Exception {


    }
}
