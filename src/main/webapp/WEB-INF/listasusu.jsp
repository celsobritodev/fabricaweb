
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

<script type="text/javascript">
	function confirmaExclusao(id) {
		if (window.confirm('Tem certeza que deseja excluir o número '+id+'? ')) {
			location.href = "UsuarioController?acao=exc&id="+id;
		}
	}
</script>




</head>
<body>
	<%
	// preciso remover o aviso de "casting" aqui
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
	%>
	<table border=1>
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>Ação</th>
		</tr>

		<%
		for (Usuario u : usuarios) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getNome()%></td>
			<td><a href="javascript:confirmaExclusao(<%=u.getId()%>) ">	excluir </a> | <a href="UsuarioController?acao=alt&id=<%=u.getId()%> ">alterar</a>        </td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>