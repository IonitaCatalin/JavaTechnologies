package com.laboratories.labs1;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "servlet", value = "/servlet")
public class Servlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();

        this.log("Method:" + request.getMethod() + "/"
                + "User-Agent:" + request.getHeader("User-Agent") + "/"
                + "IP:" + request.getRemoteAddr() + "/"
                + "Language:" + request.getLocales() + "/"
                + "Parameter:" + request.getParameterMap().toString());

        int value;
        String key;
        boolean mock,sync;

        if (request.getParameterMap().containsKey("value")) {
            try {
                value = Integer.parseInt(request.getParameter("value"));
            } catch (NumberFormatException exception) {
                System.err.println("NumberFormatException: " + exception.getMessage());
                out.println("Something went wrong while processing your request!");
            }
        } else {
            out.println("value parameter is required for calling the servlet service!");
            return;
        }

        if (request.getParameterMap().containsKey("mock")) {
            mock = Boolean.parseBoolean(request.getParameter("mock"));
        } else {
            out.println("mock parameter is required for calling the servlet service!");
            return;
        }

        if (request.getParameterMap().containsKey("sync")) {
            sync = Boolean.parseBoolean(request.getParameter("sync"));
        } else {
            out.println("sync parameter is required for calling the servlet service!");
            return;
        }

        if (request.getParameterMap().containsKey("key")) {
            key = request.getParameter("key");
        } else {
            out.println("key parameter is required for calling the servlet service!");
            return;
        }

        if(mock) {
            out.println("Confirmation of request!");
        } else {

        }


    }

    public void destroy() {

    }
}