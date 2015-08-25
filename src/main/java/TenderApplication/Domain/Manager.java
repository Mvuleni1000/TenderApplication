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
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;

    public Manager() {
    }

    private Manager(Builder builder) {
        this.id = builder.id;
        this.surname = builder.surname;
    }

    public Long getManagerID() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public static class Builder {
        private Long  id;
        private String surname;


        public Builder(String surname)
        {surname = this.surname;
        }

        public Builder getID(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(Manager value) {
            this.id = value.getManagerID();
            this.surname = value.getSurname();
            return this;
        }
        public Manager build()
        {
            return new  Manager(this);
        }
    }
}
