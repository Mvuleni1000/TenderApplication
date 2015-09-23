package TenderApplication.DomainTest;

import TenderApplication.Domain.Manager;
import TenderApplication.config.factory.ManagerFactory;
import org.junit.Assert;

/**
 * Created by student on 2015/08/06.
 */
public class ManagerTest {


    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void createMananger() throws Exception {

        Manager manager = ManagerFactory
                .createManger("Mnisi");
        Assert.assertNull("Mnisi", manager.getSurname());
    }

    //@Test
    public void testUpdate() throws Exception {
        Manager manager = ManagerFactory
                .createManger("Ndebele");
        Assert.assertNull("Ndebele", manager.getSurname());

    }

    //@After
    public void tearDown() throws Exception {
    }
}
