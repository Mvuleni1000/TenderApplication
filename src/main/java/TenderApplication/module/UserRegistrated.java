package TenderApplication.module;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Company;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
public class UserRegistrated extends ResourceSupport {


    private Long userID;
    private String contactDetails;
    private String account;
    private Address building_address;
    private List<Company> company;

    public UserRegistrated() {
    }

    public String getAccount() {
        return account;
    }

    public Long getUserID() {
        return userID;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public Address getBuilding_address() {
        return building_address;
    }

    public List<Company> getCompany() {return company;}

    public UserRegistrated(Builder builder) {
        userID = builder.userID;
        contactDetails = builder.contactDetails;
        building_address = builder.building_address;
        company = builder.company;
        building_address= builder.building_address;
    }

    public static class Builder {
        private Long userID;
        private String contactDetails;
        private Address building_address;
        private List<Company>company;
        private String account;


        public Builder(String  contactDetails) {
            this.contactDetails = contactDetails;
        }

        public Builder account (String acc)
        {
            this.account = acc;
            return this;
        }

        public Builder id (Long user) {
            this.userID = user;
            return this;
        }

        public Builder address (Address building_address)
        {
            this.building_address = building_address;
            return this;
        }

        public Builder company(List<Company> company) {
            this.company = company;
            return this;
        }

        public Builder copy(UserRegistrated value) {
            this.userID = value.getUserID();
            this.contactDetails = value.getContactDetails();
            this.company = value.getCompany();
            this.building_address= value.getBuilding_address();
            this.account = value.getAccount();
            return this;
        }

        public UserRegistrated build() {
            return new UserRegistrated(this);
        }
    }





}
