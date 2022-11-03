package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.UsuarioDAO;

import java.io.IOException;
import java.util.List;

import entidade.Usuario;

//@WebServlet(name = "/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
		System.out.println("Construtor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String acao = request.getParameter("acao");

		if (acao.equals("exc")) {
			String id = request.getParameter("id");
			Usuario usu = new Usuario();
			if (id != null) {
				usu.setId(Integer.parseInt(id));
				UsuarioDAO usuarioDAO = new UsuarioDAO();

				usuarioDAO.excluir(usu);

				response.sendRedirect("UsuarioController?acao=lis");

				// response.getWriter().print("Pagina: Excluido com sucesso: " + id);

			}
		} else if (acao.equals("lis"))

		{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> usuarios = usuarioDAO.buscaTodos();

			request.setAttribute("usuarios", usuarios);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listasusu.jsp");
			dispatcher.forward(request, response);

		} else if (acao.equals("alt")) {
			String id = request.getParameter("id");
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.buscaPorId(Integer.parseInt(id));
			request.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(request, response);
		} else if (acao.equals("cad")) {
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			
			request.setAttribute("usu", usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usu = new Usuario();
		if (id != null) {
			usu.setId(Integer.parseInt(id));
		}
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usu);

		resp.getWriter().print("Pagina: Sucesso para: " + nome);
		System.out.println("Console: Sucesso para: " + nome);

	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
