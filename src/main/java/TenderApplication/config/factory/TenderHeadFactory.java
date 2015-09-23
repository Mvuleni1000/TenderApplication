package TenderApplication.config.factory;

import TenderApplication.Domain.*;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class TenderHeadFactory {

    public static TenderHeadOffice createOffice(String offficeRef, String country,Address building_address,List<Users> user,List<Employees>emp,List<Office> officeID )
    {
        TenderHeadOffice tenderHeadOffice1 = new TenderHeadOffice
                .Builder(offficeRef)
                .stateOFCountry(country)
                .building_address(building_address)
                .employees(emp)
                .users(user)
                .officeID(officeID)
                .build();
        return tenderHeadOffice1;
    }
}
