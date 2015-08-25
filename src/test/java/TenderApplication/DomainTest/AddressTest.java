package TenderApplication.DomainTest;

import TenderApplication.Domain.Address;
import TenderApplication.config.factory.AddressFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/08/06.
 */
public class AddressTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreate() throws Exception {
        int  zipcode = 8001;
        int streetNo = 11;
        String streetname = "Straint";
        String City ="City";


        Address address = AddressFactory
                .createAdress(8001, streetNo, streetname, City);

        Assert.assertEquals(0, address.getZipcode());
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = AddressFactory.createAdress(8001, 342, "dfasd", "Cape Town");

        Assert.assertEquals("Cape Town", address.getCity());
    }

    @After
    public void tearDown() throws Exception {}
}
