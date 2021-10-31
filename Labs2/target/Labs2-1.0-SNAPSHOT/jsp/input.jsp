<%@ page import="com.javatechnologies.labs2.enums.Category" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.javatechnologies.labs2.util.Repository" %>
<%@ page import="com.javatechnologies.labs2.util.Request" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Input</title>
</head>
<body>
<form method="post" style="display:flex;flex-direction:column;justify-content:center;left:50%;top:50%;position:absolute;transform:translate(-50%,-50%);">
    <label for="key">Key:</label><br>
    <input type="text" id="key" name="key"><br>
    <label for="category">Category:</label><br>
    <select id="category" name="category">
        <option value="unavailable">UNAVAILABLE</option>
        <%
            String defaultCategory = "";

            for(Cookie cookie:request.getCookies()) {
                if(cookie.getName().equalsIgnoreCase("category")) {
                    defaultCategory = cookie.getValue();
                }
            }

            for(Category category: Category.values()) {
                if(!defaultCategory.equals("") && defaultCategory.equals(category.getCategory())) {
                    out.println("<option selected value=\"" + category.getCategory()+"\">"
                            + category.getCategory().toUpperCase(Locale.ROOT) + "</option>");

                } else {
                    out.println("<option value=\""+category.getCategory()+"\">"
                            + category.getCategory().toUpperCase(Locale.ROOT) + "</option>");
                }
            }

        %>

    </select> <br>
    <label for="value" >Value:</label><br>
    <input type="text" id="value" name="value"> <br>
    <input type="submit"/>

</form>


<%

    Repository repository = Repository.getInstance();
    if(request.getMethod().equals("POST")) {

        String initCategory = getServletContext().getInitParameter("start_category");

        String category = request.getParameter("category");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        if(category == null || category.equals("unavailable")) {
            category = initCategory;
        }

        Repository.pushRequest(new Request(category,value,key));

        Cookie cookie = new Cookie("category",category);
        cookie.setMaxAge(1800);
        response.addCookie(cookie);

    }
%>



</body>
</html>