package usuario;

import java.time.LocalDate;
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
	
	// This method confirms the existence of a user
	public static boolean existe(String nomeUsu) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNomeUsu().equals(nomeUsu)) {
				return true;
			}
		}
		return false;
	}
	
	// This method changes the attribute "senha"
	public static boolean alterarSenha(String cpf, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				usuario.setSenha(senha);
				return true;
			}
		}
		return false;
	}
	
	public static boolean atualizar(String cpf,String nomeUsu, String nome, LocalDate dataNasc, String uf, String cidade, String rua, String numero) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				usuario.setNomeUsu(nomeUsu);
				usuario.setNome(nome);
				usuario.setDataNasc(dataNasc);
				usuario.setUf(uf);
				usuario.setCidade(cidade);
				usuario.setRua(rua);
				usuario.setNumero(numero);
				return true;
			}
		}
		return false;
	}
}
