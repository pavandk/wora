package org.wora.api;

import java.util.List;

import org.wora.spi.types.IdentityQueryCriterion;
import org.wora.types.Identity;

public interface IdentityManagement {

    List<Identity> getPeople();

    void addIdentity(Identity iden);

    List<Identity> getIdentity(IdentityQueryCriterion c);
}
