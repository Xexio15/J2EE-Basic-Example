package com.basicj2ee.filters;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BasicRequestFilter implements Filter {
    private FilterConfig filterConfig = null;
    private String param;

    // Default HttpServletRequest doesn't allow to setParameter values so we need a custom class that overrides getParameter
    static class FilteredRequest extends HttpServletRequestWrapper {
        public FilteredRequest(ServletRequest request) {
            super((HttpServletRequest)request);
        }

        public String filter(String input) {
            String result = String.format("%040x", new BigInteger(1, input.getBytes()));
            return result;
        }

        public String getParameter(String paramName) {
            String value = super.getParameter(paramName);
            value = filter(value);
            return value;
        }

        public String[] getParameterValues(String paramName) {
            String values[] = super.getParameterValues(paramName);
            for (int index = 0; index < values.length; index++) {
                values[index] = filter(values[index]);
            }
            return values;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

        // This gets the Parameter defined in web.xml
        this.param = filterConfig.getServletContext().getInitParameter("param1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            chain.doFilter(new FilteredRequest(request), response);
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    
   
    
}
