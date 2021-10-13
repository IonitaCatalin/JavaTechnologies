<%@ page import="com.javatechnologies.labs2.util.Repository" %>
<%@ page import="com.javatechnologies.labs2.util.Request" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Result</title>
</head>
<body>
<table style="left:50%;top:50%;position:absolute;transform:translate(-50%,-50%);">
    <tr style="border:1px solid black">
        <th style="border:1px solid black">Category</th>
        <th style="border:1px solid black">Key</th>
        <th style="border:1px solid black">Value</th>
    </tr>
<%
    Repository repository = Repository.getInstance();

    for(Request req: Repository.getRequests()) {
        out.println("<tr style=\"border:1px solid black\">"+
                        "<td style=\"border:1px solid black\">" + req.getCategory() + "</td>" +
                        "<td style=\"border:1px solid black\">" + req.getKey() + "</td>" +
                        "<td style=\"border:1px solid black\">" + req.getValue() + "</td>" +
                    "</tr>");
    }
%>
</table>
</body>
</html>