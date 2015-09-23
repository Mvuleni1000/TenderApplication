package TenderApplication.config.factory;

import TenderApplication.Domain.Contracts;

/**
 * Created by student on 2015/08/06.
 */
public class ContractFactory {

    public static Contracts createContracts(  String documents, String depName)
    {

        Contracts contracts = new Contracts
                .Builder(documents)
                .depName(depName)
                .build();
        return contracts;
    }
}
