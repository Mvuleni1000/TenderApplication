package TenderApplication.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class HRDepartment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contactdeatails;
    private String building;


    public Long getHrNo() {
        return id;
    }

    public String getContactdeatails() {
        return contactdeatails;
    }

    public String getBuilding() {
        return building;
    }

    public HRDepartment() {}

    public  HRDepartment(Builder builder) {
        this.id = builder.id;
        this.contactdeatails = builder.contactdeatails;
        this.building = builder.building;
    }

    public static class Builder
    {
        private Long id;
        private String contactdeatails;
        private String building;

        public Builder(String con) {
            con = this.contactdeatails;
        }

        public Builder buildingLocation (String building)
        {
            this.building = building;
            return this;
        }

        public Builder deatails (String contactdeatails)
        {
            this.contactdeatails = contactdeatails;
            return this;
        }

        public Builder id (Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(HRDepartment value) {
            this.id = value.id;
            this.contactdeatails = value.contactdeatails;
            this.building = value.building;
            return this;
        }
        public HRDepartment build()
        {
            return new  HRDepartment(this);
        }
    }
}
