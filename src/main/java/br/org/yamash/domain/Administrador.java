package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Administrador")
public class Administrador {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codAdmin")
	private long coAdmin;
	 
	@Column(name="nomeCompleto", length=120, nullable=false)
	private String nomeCompleto;
	 
	@Column(name="dtNascimento", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	@Column(name="cpf", length=11, nullable=false)
	private String cpf;
	 
	@Column(name="email",length=120, nullable=false)
	private String email;
	
	@Column(name="senha", length=16, nullable=false)
	private String senha;
	 
	@Column(name="telefone", length=20, nullable=true)
	private String telefone;
	 
	@Column(name="statusAdmin", nullable=false)
	private int statusAdmin;

	public long getCoAdmin() {
		return coAdmin;
	}

	public void setCoAdmin(long coAdmin) {
		this.coAdmin = coAdmin;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getStatusAdmin() {
		return statusAdmin;
	}

	public void setStatusAdmin(int statusAdmin) {
		this.statusAdmin = statusAdmin;
	}
	
	
	 	 
}
 
