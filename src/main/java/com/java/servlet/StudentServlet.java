package com.java.servlet;

import com.java.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class StudentServlet extends HttpServlet {

   public static HashMap<String, Student> map = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String university=req.getParameter("university");
        String roll=req.getParameter("rollno");








        map.put(roll,new Student(name,university,roll));

        resp.getWriter().write("Student data:"+ map.get(roll));
    }


}
