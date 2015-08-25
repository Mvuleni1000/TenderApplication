package TenderApplication.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * Created by student on 2015/08/06.
 */
@Embeddable
public class Address implements Serializable {

    private int zipcode;
    private int street_no;
    private String street_name;
    private String city;


    public Address() {

    }

    public Address(Builder builder) {
        zipcode=builder.zipCode;
        street_no=builder.street_no;
        street_name=builder.street_name;
        city = builder.city;

    }

    public int getZipcode() {
        return zipcode;
    }

    public int getStreet_no() {
        return street_no;
    }

    public String getStreet_name() {
        return street_name;
    }

    public String getCity() {
        return city;
    }

    public static class Builder{
        private int zipCode;
        private int street_no;
        private String street_name;
        private String city;

        public Builder(int street_no) {
            this.street_no = street_no;
        }

        public Builder zipCode(int value){
            this.zipCode=value;
            return this;
        }

        public Builder streetNo(int street_no)
        {
            this.street_no = street_no;
            return this;
        }

        public Builder streetName(String value){
            this.street_name=value;
            return this;
        }

        public Builder city(String value){
            this.city=value;
            return this;
        }

        public Builder copy(Address value){
            this.street_no=value.street_no;
            this.street_name=value.street_name;
            this.zipCode=value.zipcode;
            this.city=value.city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

    }
}