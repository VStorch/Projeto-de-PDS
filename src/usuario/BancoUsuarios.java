package usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoUsuarios {

	private static List<Usuario> usuarios = new ArrayList<>();
	
	public static void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static Usuario autenticar(String nomeUsu, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeUsu().equals(nomeUsu) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	public static boolean existe(String nomeUsu) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeUsu().equals(nomeUsu)) {
				return true;
			}
		}
		return false;
	}
}
