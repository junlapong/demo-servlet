package com.demo.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-attributes")
public class GetAttributesServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get application scoped attribute
        String applicationScope = (String)req.getServletContext().getAttribute("name");

        // get session scoped attribute
        HttpSession session = req.getSession();
        String sessionScope = (String)session.getAttribute("name");

        // get request scoped attribute
        String requestScope = (String)req.getAttribute("name");

        // print response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><body>\n");
        out.write("<h2>Servlet Attributes request session and application scope</h2>\n");
        out.write("<p>applicationScope: " + applicationScope + "</p>\n");
        out.write("<p>sessionScope: " + sessionScope + "</p>\n");
        out.write("<p>requestScope: " + requestScope + "</p>\n");
    }

}
