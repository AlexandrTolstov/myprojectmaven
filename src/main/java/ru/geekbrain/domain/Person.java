package ru.geekbrain.domain;

import com.google.common.hash.HashCode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Person {
    @Expose()
    private String firstName;

    @Expose()
    private String lastName;

    @Expose(serialize = false)
    private Address address;

    @Expose()
    private int age;

    @SerializedName("phones number")
    @Expose(serialize = false)
    private List<String> phones;

    public Person(String firstName, String lastName, Address address, int age, List<String> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.phones = phones;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return new EqualsBuilder().append(age, person.age).append(firstName, person.firstName).append(address, person.address).append(phones, person.phones).isEquals();
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(17, 37).append(firstName).append(lastName).append(age).append(address).append(phones).hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                '}';
    }
}
