<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number System Converter</title>
</head>
<body>
    <form action="NumberSystemServlet" method="post">
        <label for="number1">Enter the first number:</label><br>
        <input type="number" id="number1" name="number1"><br><br/>
        
        <label for="number2">Enter the second number:</label><br>
        <input type="number" id="number2" name="number2"><br><br/>
        
        
        <label for="toSystem">To System:</label><br>
        <select id="toSystem" name="toSystem">
            <option value="binary">Binary</option>
            <option value="decimal">Decimal</option>
            <option value="hexadecimal">Hexadecimal</option>
            <option value="octal">Octal</option>

        </select><br><br/>
        
        <input type="submit" class="btn btn-primary" value="Add" name="operation">
        <input type="submit" class="btn btn-primary" value="Sub" name="operation">
    </form>
</body>
</html>