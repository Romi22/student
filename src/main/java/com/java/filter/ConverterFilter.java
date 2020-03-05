package com.java.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;
import com.java.model.Student;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;



public class  ConverterFilter implements Filter {


    public void init(FilterConfig fConfig)throws ServletException
    {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request;
        Object content = req.getHeader("Accept");

        String roll=req.getParameter("id");

        PrintWriter out = response.getWriter();

       Object s =  req.getAttribute("student");

       if(content.equals(null))
       {
           response.getWriter().write(s.toString());
       }

       else {
               if (content.equals("application/json"))
               {
                       response.setContentType("application/json");
                       ObjectMapper mapper = new ObjectMapper();
                       Object json = mapper.writeValueAsString(s);
                       out.print(json);
               }
               else if (content.equals("application/xml"))
               {
                       response.setContentType("application/xml");
                       XmlMapper mapper = new XmlMapper();
                       Object xml = mapper.writeValueAsString(s);
                       out.print(xml);
               }
               else
               {
                   response.getWriter().write("\n Please Enter a Valid Type");
               }
           }


    }

    public void destroy()
    {

    }



}



