package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import persistencia.UsuarioDAO;

import java.io.IOException;

import entidade.Usuario;


//@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = req.getSession(false);
		if (sessao!=null) {
			sessao.invalidate();
		}
		
		resp.sendRedirect("login.html");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1 - Capturando dados da tela
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		// 2 - Colocando dados em objeto usuario
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		// 3 - Consultando se usuario existe no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuAutenticado = usuarioDAO.autenticar(usuario);
		
		
		// 4 - Verificando se usuairo foi encontrado
		if(usuAutenticado!=null) {
			
			
			// 5 - Colando usuario na sessao
			HttpSession sessao = request.getSession();
			
			sessao.setAttribute("usuAutenticado",usuAutenticado);
			
			sessao.setMaxInactiveInterval(60*5);
			// 6 - Redirecionando usuario para tela principal
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		} else {
			response.getWriter().print("<script> window.alert('não encontrado'); location.href='login.html'</script>");
		}
	}

}
