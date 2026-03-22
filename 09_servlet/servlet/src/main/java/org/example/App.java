package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        try {
            // 0. Getting Exisisting connection
            tomcat.getConnector();
            // 1. Add Context
            Context context = tomcat.addContext("",System.getProperty("java.io.tmpdir"));
            // 2. Add Servlet
            Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
            // 3. Map Url
            context.addServletMappingDecoded("/hello", "HelloServlet");
            // 4. Start Server
            tomcat.start();
            System.out.println("Server running at http://localhost:8080");
            // 5. Alive server
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
