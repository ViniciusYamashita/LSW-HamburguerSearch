package br.org.yamash.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Clientes")
@NamedQueries({
	@NamedQuery(name="cliente.autenticar", query="SELECT cliente FROM Clientes cliente WHERE cliente.email = :email AND cliente.senha = :senha")
})
public class Clientes {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codCliente")
	private long codCliente;
	
	@NotEmpty(message="O campo 'Nome Completo' é obrigatório.")
	@Column(name="nomeCompleto", length=120, nullable=false)
	private String nomeCompleto;
	
	@Column(name="statusCliente", nullable=false)
//	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean statusCliente;
	
	@Column(name="apelido", length=50, nullable=true)
	private String apelido;
	
	@NotEmpty(message="O campo 'E-mail' é obrigatório.")
	@Column(name="email", length=120, nullable=false)
	private String email;
	 
	@NotEmpty(message="O campo 'Senha' é obrigatório.")
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

	public boolean getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(boolean statusCliente) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codCliente ^ (codCliente >>> 32));
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
		Clientes other = (Clientes) obj;
		if (codCliente != other.codCliente)
			return false;
		return true;
	}
	
}
 
