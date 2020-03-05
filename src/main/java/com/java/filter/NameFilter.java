package com.java.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;



public class NameFilter implements Filter {


    public void destroy()
    {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException
    {

        PrintWriter out=response.getWriter();

        HttpServletRequest req=(HttpServletRequest) request;
        String sname=request.getParameter("name");

        if(sname != null && isValid(sname))
            chain.doFilter(request,response);
        else
        {
            out.print("Invalid Name Input");
        }
    }

    public void init(FilterConfig fConfig)throws ServletException
    {

    }

    private boolean isValid(String sname)
    {
        for(int i=0;i<sname.length();i++)
        {
            if(!Character.isLetter(sname.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

}



