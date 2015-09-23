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
public class Contracts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documents;
    private String depName;


    public Contracts () {}

    public Long getContractID() {
        return id;
    }

    public String getDocuments() {
        return documents;
    }

    public String getDepName() {
        return depName;
    }

    public Contracts (Builder pro) {
        this.id = pro.id;
        this.documents = pro.documents;
        this.depName = pro.depName;
    }

    public static class Builder
    {
        private Long id;
        private String documents;
        private String depName;

        public Builder(String  documents) {
            documents = this.documents;
        }


        public Builder id(Long   id){
            this.id=id;
            return this;
        }

        public  Builder depName (String depName)
        {
            this.depName = depName;
            return this;
        }

        public Builder copy(Contracts pro) {
            this.id = pro.getContractID();
            this.documents = pro.getDocuments();
            this.depName = pro.depName;

            return this;
        }

        public Contracts build() {
            return new Contracts(this);
        }
    }

}
