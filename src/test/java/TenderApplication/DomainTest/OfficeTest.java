package TenderApplication.DomainTest;

import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;
import TenderApplication.config.factory.OfficeFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class OfficeTest {

    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void testCreate() throws Exception {
        List<Department> departments = new ArrayList<Department>();
        List<HRDepartment>hrDepartments = new ArrayList<HRDepartment>();

        Office office = OfficeFactory.createAdim("Civil Tender","Western Station" ,departments, hrDepartments);
        Assert.assertEquals("Western Station", office.getStationNo());
    }

   // @Test
    public void testUpdate() throws Exception {
        List<Department> departments = new ArrayList<Department>();
        List<HRDepartment>hrDepartments = new ArrayList<HRDepartment>();

        Office office = OfficeFactory.createAdim("Civil Tender","Southern Station" ,departments, hrDepartments);
        Assert.assertEquals("Southern Station", office.getStationNo());
    }

   // @After
    public void tearDown() throws Exception {


    }
}
