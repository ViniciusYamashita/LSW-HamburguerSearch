package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

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
	 
	@NotEmpty(message="O campo 'Nome Completo' é obrigatório.")
	@Column(name="nomeCompleto", length=120, nullable=false)
	private String nomeCompleto;
	 
	@NotNull(message="O campo 'Data de Nascimento' é obrigatório.")
	@Column(name="dtNascimento", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	@CPF(message="O campo 'CPF' é obrigatório, ou invalido.")
	@Column(name="cpf", length=14, nullable=false, unique=true)
	private String cpf;
	
	@NotEmpty(message="O campo 'E-mail' é obrigatório.")
	@Column(name="email",length=120, nullable=false)
	private String email;
	
	@NotEmpty(message="O campo 'Senha' é obrigatório.")
	@Column(name="senha", length=16)
	private String senha;
	 
	@Column(name="telefone", length=20, nullable=true)
	private String telefone;
	 
	@Column(name="statusAdmin", nullable=false)
	private boolean statusAdmin;

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

	public void setDtNascimento(Date date){
		this.dtNascimento = date;
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

	public boolean getStatusAdmin() {
		return statusAdmin;
	}

	public void setStatusAdmin(boolean statusAdmin) {
		this.statusAdmin = statusAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codAdmin ^ (codAdmin >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (codAdmin != other.codAdmin)
			return false;
		return true;
	}
}
 
