package TenderApplication.DomainTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.config.factory.DepartmentFactory;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class DepartmentTest {

    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {

        List<Contracts> contractses = new ArrayList<Contracts>();

        Department d = DepartmentFactory
                .createDepartment("Human Resource","Mhlongo",contractses );

        Assert.assertEquals("Mhlongo", d.getFounder());
    }

   // @Test
    public void testUpdate() throws Exception {

        List<Contracts>departments = new ArrayList<Contracts>();

        Department d = DepartmentFactory
                .createDepartment("Human Resource", "Mvuleni", departments);
        Assert.assertEquals("Mvuleni", d.getFounder());
    }

    //@After
    public void tearDown() throws Exception {


    }
}
