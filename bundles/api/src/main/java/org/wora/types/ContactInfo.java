package org.wora.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactInfo {

    private Address address;
    private List<Phone> contactNumber = new ArrayList<Phone>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Phone... contactNumber) {
        if (contactNumber != null) {
            this.contactNumber.addAll(Arrays.asList(contactNumber));

        }
    }

}
