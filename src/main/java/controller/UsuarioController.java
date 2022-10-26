package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.UsuarioDAO;

import java.io.IOException;

import entidade.Usuario;

@WebServlet(name = "/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
		System.out.println("Contrutor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usu = new Usuario();
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
