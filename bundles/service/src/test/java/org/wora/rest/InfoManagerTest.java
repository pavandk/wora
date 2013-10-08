package org.wora.rest;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.wora.api.IdentityManagement;
import org.wora.srv.IdentityManagementImpl;
import org.wora.types.Identity;

public class InfoManagerTest {

    @Test
    public void getPeopleTest() {
        IdentityManagement inforMngr = new IdentityManagementImpl();
        List<Identity> people = inforMngr.getPeople();
        assertFalse(people.isEmpty());

    }

}
