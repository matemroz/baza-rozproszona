<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz dodawania nowego konta klientowi</title>
</head>
<body>
	<h1>Formularz dodawania nowego konta klientowi</h1>
    <form action="addClientAccountServlet" method="POST">
    	<h3>Dane osobiste</h3>
        Imię: <input type="text" name="imie" size="20"><br>
        Nazwisko: <input type="text" name="nazwisko" size="20"><br>
        Ulica zamieszkania: <input type="text" name="ulicaZamieszkania" size="20"><br>
        Nr domu: <input type="text" name="nrDomu" size="20"><br>
        Nr mieszkania: <input type="text" name="nrMieszkania" size="20"><br>
        Nr telefonu: <input type="text" name="nrTelefonu" size="20"><br>
        Nr dowodou osobistego: <input type="text" name="nrDowoduOsobistego" size="20"><br>
        Nr paszportu: <input type="text" name="nrPaszportu" size="20"><br>
        Pesel: <input type="text" name="pesel" size="20"><br>
        <br>
        <h3>Dane konta</h3>
        Środki inicjalne: <input type="text" name="srodkiInicjalne" size="20"><br>
        Rodzaj konta: <input type="text" name="rodzajKonta" size="20"><br>
        <br><br>
        <input type="submit" value="Dodaj">
    </form>
    <a href="index.jsp">Powrót</a>
</body>
</html>