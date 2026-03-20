package org.example;

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

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
