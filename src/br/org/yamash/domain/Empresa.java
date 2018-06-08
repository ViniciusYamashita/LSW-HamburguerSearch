package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name="Empresa")
@NamedQueries({
	@NamedQuery(name="empresa.autenticar", query="SELECT empresa FROM Empresa empresa WHERE empresa.nomeUsuario = :nomeUsuario AND empresa.senha = :senha")
})
public class Empresa {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codEmpresa")
	private long codEmpresa;
	 
	@CNPJ(message="O campo 'CNPJ' é obirgatório, ou inválido.")
	@Column(name="cnpj", length=18, nullable=false)
	private String cnpj;
	 
	@NotEmpty(message="O campo 'Nome da Empresa' é obirgatório, ou inválido.")
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	
	@NotEmpty(message="O campo 'Razão social/Fantasia' é obirgatório, ou inválido.")
	@Column(name="razaoSocialFantasia", length=255, nullable=false)
	private String razaoSocialFantasia;
	 
	@NotEmpty(message="O campo 'CEP' é obirgatório, ou inválido.")
	@Column(name="cep", length=9, nullable=false)
	private String cep;
	 
	@NotEmpty(message="O campo 'Logradouro' é obirgatório, ou inválido.")
	@Column(name="logradouro", length=255, nullable=false)
	private String logradouro;
	 
	@NotEmpty(message="O campo 'Bairro' é obirgatório, ou inválido.")
	@Column(name="bairro", length=100, nullable=false)
	private String bairro;
	 
	@NotEmpty(message="O campo 'Nº' é obirgatório, ou inválido.")
	@Column(name="numeroLocal", length=10, nullable=false)
	private String numeroLocal;
	 
	@NotEmpty(message="O campo 'E-mail' é obirgatório, ou inválido.")
	@Column(name="email", length=120, nullable=false)
	private String email;
	
	@NotEmpty(message="O campo 'Nome de Usuário' é obirgatório, ou inválido.")
	@Column(name="nomeUsuario", length=40, nullable=false)
	private String nomeUsuario;
	
	@NotEmpty(message="O campo 'Senha' é obirgatório, ou inválido.")
	@Column(name="senha", length=16, nullable=false)
	private String senha;
	 
	@Column(name="telefone", length=15)
	private String telefone;
	 
	@Column(name="nomeProprietario", length=120)
	private String nomeProprietario;
	 
	@NotNull(message="O campo 'Horario de Abertura' é obirgatório, ou inválido.")
	@Column(name="horarioAbertura", columnDefinition="TIME", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horarioAbertura;
	 
	@NotNull(message="O campo 'Horario de Fechamento' é obirgatório, ou inválido.")
	@Column(name="horarioFechamento", columnDefinition="TIME", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horarioFechamento;

	@Column(name="segunda", nullable=false)
	private boolean segunda;

	@Column(name="terca", nullable=false)
	private boolean terca;
	
	@Column(name="quarta", nullable=false)
	private boolean quarta;

	@Column(name="quinta", nullable=false)
	private boolean quinta;
	
	@Column(name="sexta", nullable=false)
	private boolean sexta;
	
	@Column(name="sabado", nullable=false)
	private boolean sabado;
	
	@Column(name="domingo", nullable=false)
	private boolean domingo;
	
	@Column(name="validado", nullable=false)
	private boolean validado;
	 
	@Column(name="statusEmpresa", nullable=false)
	private boolean statusEmpresa;

	
	public long getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(long codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocialFantasia() {
		return razaoSocialFantasia;
	}

	public void setRazaoSocialFantasia(String razaoSocialFantasia) {
		this.razaoSocialFantasia = razaoSocialFantasia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public Date getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(Date horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Date getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(Date horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public boolean isSegunda() {
		return segunda;
	}

	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}

	public boolean isTerca() {
		return terca;
	}

	public void setTerca(boolean terca) {
		this.terca = terca;
	}

	public boolean isQuarta() {
		return quarta;
	}

	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}

	public boolean isQuinta() {
		return quinta;
	}

	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}

	public boolean isSexta() {
		return sexta;
	}

	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public boolean isStatusEmpresa() {
		return statusEmpresa;
	}

	public void setStatusEmpresa(boolean statusEmpresa) {
		this.statusEmpresa = statusEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codEmpresa ^ (codEmpresa >>> 32));
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
		Empresa other = (Empresa) obj;
		if (codEmpresa != other.codEmpresa)
			return false;
		return true;
	}

}
 
