package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class Employees implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String contactDetails;


    @Embedded
    private Address building_address;


    public long getEmployeeID() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public Address getBuilding_address() {
        return building_address;
    }

    public Employees() {
    }

    public Employees (Builder builder)
    {
        this.id = builder.id;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.contactDetails = builder.contactDetails;
        this.building_address = builder.building_address;

    }

    public static class Builder
    {
        private Long id;
        private String firstname;
        private String lastname;
        private String contactDetails;
        private Address building_address;


        public Builder(String  f) {
            this.firstname = f;
        }

        public Builder id (Long id)
        {
            this.id = id;
            return this;
        }


        public Builder address(Address building_address)
        {
            this.building_address = building_address;
            return  this;
        }

        public Builder lastname(String lastname)
        {
            this.lastname = lastname;
            return  this;
        }

        public Builder contact (String  contactDetails)
        {
            this.contactDetails = contactDetails;
            return  this;
        }

        public Builder copy(Employees value) {
            this.id = value.getEmployeeID();
            this.firstname = value.getFirstname();
            this.lastname = value.getLastname();
            this.building_address = value.getBuilding_address();
            this.contactDetails = value.getContactDetails();
            return this;
        }

        public Employees build()
        {
            return new  Employees(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        return id.equals(employees.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstname + "" + "Surname: " + lastname;
    }
}



