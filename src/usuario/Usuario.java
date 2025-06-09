package usuario;

import java.time.LocalDate;

public class Usuario {

	// General informations
	private String nomeUsu;
	private String nome;
	private String cpf;
	private String senha;
	private LocalDate dataNasc; // Can be null
	
	// Address (Can be null)
	private String uf;
	private String cidade;
	private String rua;
	private String numero;
	private String modeloCarro;
	private String data;
	
	public Usuario(String nomeUsu, String nome, String cpf, String senha) {
		this.nomeUsu = nomeUsu;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public void setUltimaReserva(String modelo, String data) {
		this.modeloCarro = modelo;
		this.data = data;
	}
	
	public String getModeloCarro() {
		return modeloCarro;
	}
	
	public String getData() {
		return data;
	}
	
	public String getNomeUsu() {
		return nomeUsu;
	}
	
	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	// I don't create the method setCPF because a person's CPF can't be altered
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}