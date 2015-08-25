package TenderApplication.config.factory;

import TenderApplication.Domain.Address;

/**
 * Created by student on 2015/08/06.
 */
public class AddressFactory {

    public static Address createAdress(int zipCode, int street_no, String street_name, String city)
    {
        Address address = new Address
                .Builder(zipCode)
                .streetName(street_name)
                .streetNo(street_no)
                .city(city)
                .build();
        return address;
    }
}
