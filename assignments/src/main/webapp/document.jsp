<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Text Processing</title>
</head>
<link rel="stylesheet" type="text/css" href="document.css">
<body>
    <h1>Text Processing</h1>
    <form action="DocumentServlet" method="post">
    <h1>Tokenize</h1>
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
       <!--  <label for="paragraph">Enter a paragraph:</label><br>
        <textarea id="paragraph" name="paragraph" rows="10" cols="50"></textarea><br>  -->
        <input type="submit"  name="submit" value="ProcessText">
    </form>
</body>
</html>
