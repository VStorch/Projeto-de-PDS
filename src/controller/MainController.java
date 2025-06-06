package controller;
import Telas.Cadastro;
import Telas.Login;
import Telas.Menu;
import Telas.QuemSomos;
import Telas.RecSenha;
import Telas.Servicos;
import Telas.SuaConta;
import usuario.Usuario;

public class MainController {

	public static void main(String[] args) {
		abrirLogin();
	}
	
	public static void abrirLogin() {
		Login login = new Login();
		login.setVisible(true);
	}
	
	public static void abrirRecSenha() {
		RecSenha recSenha = new RecSenha();
		recSenha.setVisible(true);
	}
	
	public static void abrirCadastro() {
		Cadastro cadastro = new Cadastro();
		cadastro.setVisible(true);
	}
	
	public static void abrirMenu(Usuario usuario) {
		Menu menu = new Menu(usuario);
		menu.setVisible(true);
	}
	
	public static void abrirSuaConta(Usuario usuario) {
		//new SuaConta(usuario).setVisible(true);
		SuaConta suaConta = new SuaConta(usuario);
		suaConta.setVisible(true);
	}
	
	public static void abrirServicos(Usuario usuario) {
		Servicos servicos = new Servicos(usuario);
		servicos.setVisible(true);
	}
	
	public static void abrirQuemSomos(Usuario usuario) {
		QuemSomos quemSomos = new QuemSomos(usuario);
		quemSomos.setVisible(true);
	}

}
