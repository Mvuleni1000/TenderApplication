package TenderApplication.DomainTest;

import TenderApplication.Domain.HRDepartment;
import TenderApplication.config.factory.HRDepartmentFactory;
import org.junit.Assert;

/**
 * Created by student on 2015/08/06.
 */
public class HRDepartmentTest {

    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {

        HRDepartment hrDepartment = HRDepartmentFactory
                .createHRDepartment("031595354", "8th Floor");
        Assert.assertEquals("8th Floor", hrDepartment.getBuilding());
    }

    //@Test
    public void testUpdate() throws Exception {

        HRDepartment hrDepartment = HRDepartmentFactory
                .createHRDepartment("012 5325412", "1st Floor");
        Assert.assertEquals("1st Floor", hrDepartment.getBuilding());
    }

    //@After
    public void tearDown() throws Exception {


    }
}
