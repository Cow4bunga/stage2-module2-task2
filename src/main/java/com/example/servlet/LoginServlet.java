package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (req.getSession().getAttribute("user") == null)
            res.sendRedirect("/login.jsp");
        else
            res.sendRedirect("/user/hello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if (Users.getInstance().getUsers().contains("login")
                && !req.getParameter("password").isEmpty()) {
            req.getSession().setAttribute("user", "user");
            res.sendRedirect(" /user/hello.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp.*/").forward(req, res);
        }
    }

}