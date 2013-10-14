package org.wora.srv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wora.api.IdentityManagement;
import org.wora.spi.types.IdentityQueryCriterion;
import org.wora.types.ContactInfo;
import org.wora.types.Gender;
import org.wora.types.Identity;
import org.wora.types.Phone;

public class IdentityManagementImpl implements IdentityManagement {

    public IdentityManagementImpl() {

        loadHardCoded();//TODO mongodb code comes here

    }

    private void loadHardCoded() {
        Identity h = new Identity("harsha", "hegde");
        h.setGender(Gender.MALE);
        ContactInfo hhContact = new ContactInfo();
        hhContact.setContactNumber(new Phone("91", " 0", "9008588011"));
        h.setContact(hhContact);
        identities.put(h.getId(), h);

        Identity vin = new Identity("vinay", "ranganath");
        vin.setMiddleName("kumar");
        vin.setGender(Gender.MALE);
        identities.put(vin.getId(), vin);

        Identity venk = new Identity("venkatesh", "ilango");
        venk.setGender(Gender.MALE);
        identities.put(venk.getId(), venk);

    }

    private static final Logger log = LoggerFactory.getLogger(IdentityManagementImpl.class);

    @SuppressWarnings("serial")
    private final Map<UUID, Identity> identities = Collections.synchronizedMap(new LinkedHashMap<UUID, Identity>() {
        final private int clearTriggerThreshold = 1000;

        protected boolean removeEldestEntry(Map.Entry<UUID, Identity> eldest) {
            if (size() >= clearTriggerThreshold) {
                log.warn("cache over flow, Identities cache filled with {} identities and threshold is {}", size(), clearTriggerThreshold);
            }
            return false;
        }
    });

    @Override
    public List<Identity> getPeople() {

        return new ArrayList<Identity>(identities.values());

    }

    @Override
    public void addIdentity(Identity iden) {
        identities.put(iden.getId(), iden);
    }

    @Override
    public List<Identity> getIdentity(IdentityQueryCriterion c) {
        // TODO Auto-generated method stub
        return null;
    }

}
