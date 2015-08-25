package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class Department implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentNo;
    private String projects;
    private String founder;



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Contract_ID")
    private List<Contracts> contractID;

    public Department() {
    }

    public Long getDepartmentNo() {
        return departmentNo;
    }

    public String getProjects() {
        return projects;
    }

    public List<Contracts> getContractID() {
        return contractID;
    }
    public String getFounder() {
        return founder;
    }

    public Department (Builder pro)
    {
        this.departmentNo = pro.departmentNo;
        this.projects = pro.projects;
        this.contractID = pro.contractID;
        this.founder = pro.founder;
    }


    public static class Builder
    {
        private Long departmentNo;
        private String projects;
        private List <Contracts> contractID;
        private String founder;


        public Builder(String  projects) {
            projects = this.projects;
        }

        public Builder id (Long departmentNo)
        {
            this.departmentNo = departmentNo;
            return  this;
        }


        public Builder projects(String  projects){
            this.projects=projects;
            return this;
        }

        public Builder foundedBy (String founder)
        {
            this.founder = founder;
            return this;
        }

        public Builder contractID(List<Contracts> contractID) {
            this.contractID = contractID;
            return this;
        }

        public Builder copy(Department pro) {
            this.departmentNo = pro.getDepartmentNo();
            this.projects = pro.getProjects();
            this.contractID = pro.getContractID();
            this.founder = pro.getFounder();
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }

}
