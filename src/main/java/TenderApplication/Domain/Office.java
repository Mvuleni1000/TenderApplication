package TenderApplication.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@Entity
public class Office implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long adminNo;

    private  String document;
    private String stationNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Dep_No")
    private List<Department> departments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "HumanResoure_Id")
    private List<HRDepartment> hrDepNo;


    public Office() {}

    public String getStationNo() {
        return stationNo;
    }

    public Long getadminNo() {
        return adminNo ;
    }

    public String getDocument() {
        return document;
    }

    public List<Department> getdepartments() {
        return departments;
    }

    public List<HRDepartment> getHrDepNo() {
        return hrDepNo;
    }

    public Office(Builder builder)
    {
        this.adminNo=builder.adminNo;
        this.document=builder.document;
        this.departments=builder.departments;
        this. hrDepNo = builder.hrDepNo;
        this.stationNo = builder.stationNo;
    }


    public static class Builder
    {
        private  Long adminNo;
        private  String document;
        private List<Department> departments;
        private List<HRDepartment> hrDepNo;
        private String stationNo;


        public Builder(String document) {document = this.document;}


        public Builder id(Long  adminNo){
            this.adminNo=adminNo;
            return this;
        }
        public Builder station(String stationNo)
        {
            this.stationNo = stationNo;
            return  this;
        }

        public Builder departments(List<Department> departments) {
            this.departments = departments;
            return this;
        }

        public Builder hrDep(List<HRDepartment> hrDepNo) {
            this.hrDepNo = hrDepNo;
            return this;
        }

        public Builder copy(Office workers) {
            this.adminNo = workers.getadminNo();
            this.document = workers.getDocument();
            this.departments = workers.getdepartments();
            this.hrDepNo = workers.getHrDepNo();
            this.stationNo = workers.getStationNo();
            return this;
        }

        public Office build() {return new Office(this);}
    }




}
