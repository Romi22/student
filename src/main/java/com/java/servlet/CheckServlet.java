package com.java.servlet;

import com.java.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class CheckServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String roll = req.getParameter("id");

        Student s = StudentServlet.map.get(roll);
                //new Student(StudentServlet.map.get(roll).name, StudentServlet.map.get(roll).rollno, StudentServlet.map.get(roll).university);

        req.setAttribute("student", s);



        resp.getWriter().write("Student data:"+ StudentServlet.map.get(roll));

    }
}
