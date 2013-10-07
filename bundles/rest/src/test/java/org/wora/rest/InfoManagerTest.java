package org.wora.rest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.wora.types.Person;

import com.google.gson.Gson;

public class InfoManagerTest {

    @Test
    public void getPeopleTest() {
        InfoManagerImpl inforMngr = new InfoManagerImpl();
        List<Person> people = inforMngr.getPeople();
        assertFalse(people.isEmpty());
        assertNotNull(new Gson().toJson(people));

    }

}
