package com.java.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.log("\n#########################################################################################\n");

        servletContext.log("contextInitialized Method has been called in "+this.getClass().getName());

        servletContext.log(servletContext+" is initialized or created");
        Properties properties = new Properties();


        String path = servletContext.getInitParameter("PROPERTY_FILE");

            try (InputStream input = new FileInputStream(path))
            {
                properties.load(input);

                servletContext.setAttribute("properties",properties);

             }
            catch (IOException ex) {
            ex.printStackTrace();
        }


        servletContext.log("\n#########################################################################################\n");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.log("\n#########################################################################################\n");

        servletContext.log("contextDestroy Method has been called in "+this.getClass().getName());



        servletContext.log(servletContext+" is destroyed");

        servletContext.log("\n#########################################################################################\n");

    }
}
