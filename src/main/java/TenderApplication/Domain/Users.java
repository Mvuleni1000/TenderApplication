package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    private String contactDetails;
    private String account;

    @Embedded
    private Address building_address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "companyNo")
    private List<Company> company;

    public Users() {
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

    public Users(Builder builder) {
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

        public Builder copy(Users value) {
            this.userID = value.getUserID();
            this.contactDetails = value.getContactDetails();
            this.company = value.getCompany();
            this.building_address= value.getBuilding_address();
            this.account = value.getAccount();
            return this;
        }

        public Users build() {
            return new Users(this);
        }
    }


}
