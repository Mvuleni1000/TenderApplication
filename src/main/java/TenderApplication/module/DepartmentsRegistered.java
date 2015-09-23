package TenderApplication.module;

import TenderApplication.Domain.Contracts;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by student on 2015/09/17.
 */
public class DepartmentsRegistered extends ResourceSupport {


    private Long departmentNo;
    private String projects;
    private String founder;
    private List<Contracts> contractID;

    public DepartmentsRegistered() {
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

    public DepartmentsRegistered (Builder pro)
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

        public Builder copy(DepartmentsRegistered pro) {
            this.departmentNo = pro.getDepartmentNo();
            this.projects = pro.getProjects();
            this.contractID = pro.getContractID();
            this.founder = pro.getFounder();
            return this;
        }

        public DepartmentsRegistered build() {
            return new DepartmentsRegistered(this);
        }
    }


}
