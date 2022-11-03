
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuários</title>
</head>
<body>
	<%
	// preciso remover o aviso de "casting" aqui
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

	out.print("<table border=1>");
	out.print("<tr><th> id </th> <th>nome</th> </tr>");

	for (Usuario u : usuarios) {
		out.print("<tr>");
		out.println("<td> id: " + u.getId() + "</td> <td> Nome: " + u.getNome() + "</td>");
		out.println("</tr>");
	}
	%>
</body>
</html>