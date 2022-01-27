<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
    <body>
        <h1>I'M A SERVLET SERVING A JSP WITH A VARIABLE</h1>
        The Servlet says that the variable value is: ${example}
        <% 
        boolean filtered = (boolean) request.getAttribute("filtered");
        if (filtered){
            out.println("The variable has been filtered by BasicRequestFilter.java");
            out.println("Check <filters> in web.xml");
        }
        %>
    </body>
</html>