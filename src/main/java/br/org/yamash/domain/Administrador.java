package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name="Administrador")
@NamedQueries({
	@NamedQuery(name="administrador.autenticar", query="SELECT admin FROM Administrador admin WHERE admin.cpf = :cpf AND admin.senha = :senha")
})
public class Administrador {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codAdmin")
	private long codAdmin;
	 
	@Column(name="nomeCompleto", length=120, nullable=false)
	private String nomeCompleto;
	 
	@Column(name="dtNascimento", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	@NotEmpty(message="O campo 'CPF' é obrigatório.")
	@Column(name="cpf", length=11, nullable=false, unique=true)
	private String cpf;
	
	@NotEmpty(message="O campo 'e-mail' é obrigatório.")
	@Column(name="email",length=120, nullable=false)
	private String email;
	
	@Column(name="senha", length=16)
	private String senha;
	 
	@Column(name="telefone", length=20, nullable=true)
	private String telefone;
	 
	@Column(name="statusAdmin", nullable=false)
	private int statusAdmin;

	public long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
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
 
