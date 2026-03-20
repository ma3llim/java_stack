package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    public void services(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Hello From Servlet");
    }
}
