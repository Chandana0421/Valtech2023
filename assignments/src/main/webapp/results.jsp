<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Processing Results</title>
</head>
<link rel="stylesheet" type="text/css" href="result.css">
<body>
    <h1>Processing Results</h1>
    <p><strong>Inputted Text:</strong></p>
     <%
     String path = (String) request.getAttribute("path");
     BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = reader.readLine())!= null){
            sb.append(line+"\n");
        }
        out.print(sb);
        %>
    <p><strong>Total Word Count is:</strong></p>
    <p><%= request.getAttribute("totalWordCount") %></p>
    <p><strong>Remaining Word Counts:</strong></p>
    <ul>
      
        <c:forEach var="entry" items="${wordCountMap}">
            <li>${entry.key}: ${entry.value}</li>
        </c:forEach>
       
    </ul>
</body>
</html>
