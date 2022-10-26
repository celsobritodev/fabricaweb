package test;

import java.util.List;

import entidade.Usuario;
import persistencia.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		// testeSalvar();
		// testeCadastrar();
		//testBuscarPorId();
		//testeBuscarTodos();
		testeAutenticar();
		

	}


	private static void testeAutenticar() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("maria");
		usu.setSenha("mary");
		if (usuDAO.autenticar(usu)!=null) {
			System.out.println("autenticado");
		} else {
			System.out.println("não autenticado");	
		}
			
		
		
	}


	public static void testeAlterar() {
		// criando o usuario
		Usuario usu = new Usuario();
		usu.setId(8);
		usu.setNome("Celsim Britim");
		usu.setLogin("cersim");
		usu.setSenha("2006");

		// cadastrando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		System.out.println("alterado com sucesso");
	}
	
	
	public static void testeCadastrar() {
		// criando o usuario
		Usuario usu = new Usuario();
		usu.setNome("Celso Brito");
		usu.setLogin("celso");
		usu.setSenha("1966");

		// cadastrando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		System.out.println("Cadastrado com sucesso");
	}

	public static void testeExcluir() {
		// criando o usuario
		Usuario usu = new Usuario();
		usu.setId(9);

		// excluindo
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		System.out.println("Excluido com sucesso");
	}

	

	public static void testBuscarPorId() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscaPorId(10);
		System.out.println(usuario.toString());

	}


	
	public static void testeSalvar() {
		Usuario usu = new Usuario();
		usu.setId(null);
		usu.setNome("Virmerson");
		usu.setLogin("vir");
		usu.setSenha("mess2020");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);

		System.out.println("Salvao com sucesso");
	}

	public static void testeBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuDAO.buscaTodos();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}

	}

}
