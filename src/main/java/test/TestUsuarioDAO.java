package test;


import entidade.Usuario;
import persistencia.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		testeExcluir();
	
	}
	
	public static void testeAlterar() {
		// criando o usuario
		Usuario usu = new Usuario();
		usu.setId(8);
		usu.setNome("Celsim Britim");
		usu.setLogin("cersim");
		usu.setSenha("2006");
		
		// cadastrando
		UsuarioDAO usuDAO= new UsuarioDAO();
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
		UsuarioDAO usuDAO= new UsuarioDAO();
		usuDAO.cadastrar(usu);
		System.out.println("Cadastrado com sucesso");
	}
	
	public static void testeExcluir() {
		// criando o usuario
		Usuario usu = new Usuario();
		usu.setId(9);
		
		// cadastrando
		UsuarioDAO usuDAO= new UsuarioDAO();
		usuDAO.excluir(usu);
		System.out.println("Excluido com sucesso");
	}

}
