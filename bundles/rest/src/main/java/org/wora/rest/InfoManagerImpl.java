package org.wora.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wora.types.ContactInfo;
import org.wora.types.Gender;
import org.wora.types.Person;
import org.wora.types.Phone;

import com.google.gson.Gson;

public class InfoManagerImpl extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        final PrintWriter out = resp.getWriter();
        try {
            List<Person> people = getPeople();
            String responseJson = new Gson().toJson(people);
            out.println(responseJson);
        } catch (Throwable t) {
            t.printStackTrace(out);
        } finally {
            out.flush();
        }
    }

    List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        Person h = new Person("harsha", "hegde", "1");
        h.setGender(Gender.MALE);
        ContactInfo hhContact = new ContactInfo();
        hhContact.setContactNumber(new Phone("91", " 0", "9008588011"));
        h.setContact(hhContact);

        Person vin = new Person("vinay", "ranganath", "1");
        vin.setMiddleName("kumar");
        vin.setGender(Gender.MALE);

        Person venk = new Person("venkatesh", "ilango", "1");
        venk.setGender(Gender.MALE);

        people.addAll(Arrays.asList(h, vin, venk));

        return people;

    }

}
