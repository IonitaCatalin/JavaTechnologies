package com.javatechnologies.labs2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/input.jsp")
public class LoggerFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        config.getServletContext().log("Method:" + request.getMethod() + "/" + "Parameters:"
                + request.getParameterMap().toString() + "User-Agent:" + request.getRemoteUser());

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
