package br.org.yamash.domain;

public class Usuario {
	
	private Clientes usuario;
	
	private String login;
	
	private String senha;
	
	public Clientes getUsuarioSup() {
		return usuario;
	}

	public void setUsuarioSup(Clientes usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
