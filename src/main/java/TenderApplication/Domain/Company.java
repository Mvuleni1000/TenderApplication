package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class Company implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;
    private String taxclarance;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "MangerID")
    private List<Manager> managerID;

    public Company() {
    }

    public Long getCompanyNo() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getTaxclarance() {
        return taxclarance;
    }
    public List<Manager> getManagerID() {
        return managerID;
    }

    public Company(Builder builder) {

        this.id = builder.id;
        this.taxclarance = builder.taxclarance;
        this.managerID = builder.managerID;
        this.name = builder.name;
    }

    public static class Builder
    {
        private Long id ;
        private String name;
        private String taxclarance;
        private List<Manager> managerID;

        public Builder(String  name) {
            name = this.name;
        }

        public Builder companyNo(Long id)
        {
            this.id = id;
            return this;
        }


        public Builder taxclarance(String  taxclarance){
            this.taxclarance=taxclarance;
            return this;
        }

        public Builder managerID(List<Manager> managerID) {
            this.managerID = managerID;
            return this;
        }

        public Builder copy(Company workers) {
            this.name = workers.getName();
            this.id = workers.getCompanyNo();
            this.taxclarance = workers.getTaxclarance();

            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
