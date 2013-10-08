package org.wora.rest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.wora.types.Identity;

import com.google.gson.Gson;

public class InfoManagerTest {

    @Test
    public void getPeopleTest() {
        Personage inforMngr = new Personage();
        List<Identity> people = inforMngr.getPeople();
        assertFalse(people.isEmpty());
        assertNotNull(new Gson().toJson(people));

    }

}
