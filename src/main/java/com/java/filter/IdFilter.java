package com.java.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;



public class IdFilter implements Filter {


    public void destroy()
    {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException
    {

        PrintWriter out=response.getWriter();

        HttpServletRequest req=(HttpServletRequest) request;
        String sid=request.getParameter("rollno");

        if(sid != null && isValid(sid))
            chain.doFilter(request,response);
        else
        {
             out.print("Invalid ID Input");
        }
    }

    public void init(FilterConfig fConfig)throws ServletException
    {

    }

    private boolean isValid(String roll) {
        if (roll.length() < 3) {
            return false;
        }
        if (roll.charAt(0) == 'R' && roll.charAt(1) == 'N') {
            for (int i = 2; i < roll.length(); i++) {
                if (!isNumeric(roll.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isNumeric(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}



