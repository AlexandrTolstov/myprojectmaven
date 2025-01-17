package ru.geekbrain.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Address {
    private String city;
    private String street;
    private int buildingNo;

    public Address(String city, String street, int buildingNo){
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return new EqualsBuilder().append(buildingNo, address.buildingNo).append(city, address.city).append(street, address.street).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(city).append(street).append(buildingNo).toHashCode();
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNo=" + buildingNo +
                '}';
    }
}
