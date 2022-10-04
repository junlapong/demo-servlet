package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/set-attributes")
public class SetAttributesServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // set application scoped attribute
        req.getServletContext().setAttribute("name", "application scoped attribute");

        // set session scoped attribute
        HttpSession session = req.getSession();
        session.setAttribute("name", "session scoped attribute");

        // set request scoped attribute
        req.setAttribute("name", "request scoped attribute");

        // send redirect to other servlet
        req.getRequestDispatcher("get-attributes").forward(req, resp);
    }

}
