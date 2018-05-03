package br.org.yamash.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Clientes {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codCliente")
	private long codCliente;
	
	@Column(name="nomeCompleto", length=120, nullable=false)
	private String nomeCompleto;

	@Column(name="statusCliente", nullable=false)
	private int statusCliente;
	 
	@Column(name="apelido", length=50, nullable=true)
	private String apelido;
	 
	@Column(name="email", length=120, nullable=false)
	private String email;
	 
	@Column(name="senha", length=16, nullable=false)
	private String senha;

	public long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(long codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(int statusCliente) {
		this.statusCliente = statusCliente;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	 
}
 
