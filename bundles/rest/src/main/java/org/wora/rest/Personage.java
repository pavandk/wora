package org.wora.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wora.api.IdentityManagement;
import org.wora.srv.IdentityManagementImpl;
import org.wora.types.Identity;

import com.google.gson.Gson;

public class Personage extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IdentityManagement identityManager;

    private static final Logger log = LoggerFactory.getLogger(Personage.class);

    @Override
    public void init() throws ServletException {
        identityManager = new IdentityManagementImpl();
        super.init();
    };

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Received Request on host: " + req.getLocalName() + ", socket address:" + req.getLocalAddr() + ":" + req.getLocalPort()
                + " at time: " + new Date(System.currentTimeMillis()) + " from client: " + req.getRemoteAddr());

        resp.setContentType("text/plain");
        final PrintWriter out = resp.getWriter();
        try {
            List<Identity> people = identityManager.getPeople();
            String responseJson = new Gson().toJson(people);
            out.println(responseJson);
        } catch (Throwable t) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.error("Error in GET", t);
            t.printStackTrace(out);
        } finally {
            out.flush();
        }
    }

}
