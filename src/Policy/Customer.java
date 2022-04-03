package Policy;

import java.io.Serializable;

public class Customer implements Serializable {

    String firstName, lastName, city;
    int c_phone;
    Policy policy;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String city, int c_phone, Policy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.c_phone = c_phone;
        this.policy = policy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getC_phone() {
        return c_phone;
    }

    public Policy getPolicy() {
        return policy;
    }

    @Override
    public String toString() {
        return  "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nCity: " + city +
                "\nPhone Number: " + c_phone +
                "\n" + policy;
    }
}
