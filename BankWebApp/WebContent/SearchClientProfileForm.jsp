<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz wyszukiwania profili klientów</title>
</head>
<body>
	<h1>Formularz wyszukiwania profili klientów</h1>
    <form action="searchClientProfileServlet" method="POST">
		Nr konta: <input type="text" name="nrKonta" size="20"><br>
        <br><br>
        <input type="submit" value="Wyszukaj">
    </form>
    <a href="index.jsp">Powrót</a>
</body>
</html>