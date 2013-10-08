package org.wora.srv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wora.api.IdentityManagement;
import org.wora.types.ContactInfo;
import org.wora.types.Gender;
import org.wora.types.Identity;
import org.wora.types.Phone;

public class IdentityManagementImpl implements IdentityManagement {

    @Override
    public List<Identity> getPeople() {

        List<Identity> people = new ArrayList<Identity>();
        Identity h = new Identity("harsha", "hegde", "1");
        h.setGender(Gender.MALE);
        ContactInfo hhContact = new ContactInfo();
        hhContact.setContactNumber(new Phone("91", " 0", "9008588011"));
        h.setContact(hhContact);

        Identity vin = new Identity("vinay", "ranganath", "1");
        vin.setMiddleName("kumar");
        vin.setGender(Gender.MALE);

        Identity venk = new Identity("venkatesh", "ilango", "1");
        venk.setGender(Gender.MALE);

        people.addAll(Arrays.asList(h, vin, venk));

        return people;

    }

}
