<%@page import="entidade.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="menu.jsp" %>

 <h1>Bem vindo </h1>

 <% Usuario usuario = (Usuario) request.getSession().getAttribute("usuAutenticado");
 out.print(usuario.getNome()); 
  // (Usuario) request.getSession().getAttribute("usuAtenticado").getNome()
  %>
</body>
</html>