package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class TenderHeadOffice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tenderHeadOffice;
    private String officeReg;
    private String state;

    @Embedded
    private Address building_address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "UserAdmin_ID")
    private List<Users> user;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Emp_ID")
    private List<Employees>employeeses;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Office_No")
    private List<Office>officeID;

    private TenderHeadOffice() {
    }

    public String getState() {
        return state;
    }

    public Long getTenderHeadOffice() {
        return tenderHeadOffice;
    }

    public String getOfficeReg() {
        return officeReg;
    }

    public Address getBuilding_address() {
        return building_address;
    }

    public List<Users> getUser() {
        return user;
    }

    public List<Employees> getEmployeeses() {
        return employeeses;
    }

    public List<Office> getOfficeID() {
        return officeID;
    }

    private TenderHeadOffice(Builder builder)
    {
        this.officeReg = builder.officeReg;
        this.building_address = builder.building_address;
        this.employeeses = builder.employeeses;
        this.tenderHeadOffice=builder.tenderHeadOffice;
        this.officeID = builder.officeID;
        this.user = builder.user;
        this.state = builder.state;
    }

    public static class Builder
    {
        private Long tenderHeadOffice;
        private Address building_address;
        private List<Users> user;
        private List<Employees>employeeses;
        private List<Office>officeID;
        private String officeReg;
        private String state;


        public Builder(String  officeReg) {
            this.officeReg = officeReg;
        }

        public Builder building_address(Address building_address) {
            this.building_address = building_address;
            return this;
        }

        public  Builder stateOFCountry(String RSA)
        {
            this.state = RSA;
            return this;
        }

        public Builder id (Long tenderID)
        {
            this.tenderHeadOffice =tenderID;
            return this;
        }

        public Builder users(List<Users> userz) {
            this.user = userz;
            return this;
        }

        public Builder employees(List<Employees> employees) {
            this.employeeses = employees;
            return this;
        }

        public Builder officeID (List<Office> officeID) {
            this.officeID = officeID;
            return this;
        }

        public Builder copy(TenderHeadOffice value) {
            this.tenderHeadOffice = value.getTenderHeadOffice();
            this.building_address = value.getBuilding_address();
            this.employeeses = value.getEmployeeses();
            this.user = value.getUser();
            this.officeID =value.getOfficeID();
            this.officeReg = value.officeReg;
            this.state = value.state;
            return this;
        }

        public TenderHeadOffice build() {return new  TenderHeadOffice(this);}
    }
}
