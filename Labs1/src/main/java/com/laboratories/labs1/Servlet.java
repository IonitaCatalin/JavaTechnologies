package com.laboratories.labs1;

import java.io.*;
import javax.servlet.http.*;

@javax.servlet.annotation.WebServlet(name = "Servlet", value = "/servlet")
public class Servlet extends HttpServlet {

    private final RequestService service = new RequestService();
    final Object lock = new Object();

    public void logOnRequest(HttpServletRequest request) {

        this.log("Method:" + request.getMethod() + "/"
                + "User-Agent:" + request.getHeader("User-Agent") + "/"
                + "IP:" + request.getRemoteAddr() + "/"
                + "Language:" + request.getLocales() + "/"
                + "Parameter:" + request.getParameterMap().toString());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Request clientRequest = new Request(request);

        if(clientRequest.isMock()) {
            out.println("This is a mock message from the server");
        } else {
            if(clientRequest.isSync()) {
                synchronized (lock) {
                    service.writeToRepository(clientRequest.getKey(),clientRequest.getValue());
                }
            } else {
                service.writeToRepository(clientRequest.getKey(),clientRequest.getValue());
            }

            out.println(service.formatAsCSV(service.readFromRepository()));
        }

        logOnRequest(request);
    }

    public void destroy() {

    }
}