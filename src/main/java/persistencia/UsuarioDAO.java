package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,md5(?))";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?,login=?,senha=md5(?) where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null &&usuario.getId()!=0) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}
	
	
	
	public Usuario buscaPorId(Integer id) {
		
		Usuario usuRetorno = null;
		
		String sql = "select * from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				return usuRetorno;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	
/**
 * 	Realiza a busca de todos  os registros da tabela de usuarios
 * @return
 */
	
   public List<Usuario> buscaTodos() {
		
		Usuario usuRetorno = null;
		
		String sql = "select * from usuario";
		List<Usuario> usuarios = new ArrayList<>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
	
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				usuarios.add(usuRetorno); 
			}

				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuarios;
	}

public Usuario autenticar(Usuario usuConsulta) {
	Usuario usuRetorno = null;
	String sql = "select * from usuario where login=? and senha=md5(?)";
	try (PreparedStatement preparador = con.prepareStatement(sql)) {
		preparador.setString(1, usuConsulta.getLogin());
		preparador.setString(2, usuConsulta.getSenha());
		ResultSet resultado = preparador.executeQuery();
	
		if (resultado.next()) {
			usuRetorno = new Usuario();
			usuRetorno.setId(resultado.getInt("id"));
			usuRetorno.setNome(resultado.getString("nome"));
			usuRetorno.setLogin(resultado.getString("login"));
			usuRetorno.setSenha(resultado.getString("senha"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return usuRetorno;
}




}
