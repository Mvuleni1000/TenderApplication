package TenderApplication.DomainTest;

import TenderApplication.Domain.*;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.TenderHeadFactory;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class TenderHeadTest {


    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void createTest() throws Exception {

        long tenderNo= 0;
        Address address = AddressFactory
                .createAdress(121, 2151, "Dorset", "woodstock");
        List<Users> workers              = new ArrayList<Users>();
        List<Employees> employeesList= new ArrayList<Employees>();
        List<Office> offices= new ArrayList<Office>();

        TenderHeadOffice tender = TenderHeadFactory
                .createOffice("NRS","RSA",address,workers, employeesList,offices);

        Assert.assertEquals("RSA", tender.getState());
    }

    //@Test
    public void testUpdate() throws Exception {
        Address address = AddressFactory
                .createAdress(554, 2151, "Dorset", "woodstock");
        List<Users> workers              = new ArrayList<Users>();
        List<Employees> employeesList= new ArrayList<Employees>();

        List<Office> offices= new ArrayList<Office>();

        TenderHeadOffice tender = TenderHeadFactory
                .createOffice("NRS","USA",address,workers, employeesList,offices);

        Assert.assertEquals("USA", tender.getState());

    }
}
