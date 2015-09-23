package TenderApplication.config.factory;

import TenderApplication.Domain.Manager;

/**
 * Created by student on 2015/08/06.
 */
public class ManagerFactory {

    public static Manager createManger ( String surname)
    {
        Manager man = new Manager
                .Builder(surname)
                .build();
        return man;
    }
}
