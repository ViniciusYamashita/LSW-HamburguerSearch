package br.org.yamash.domain;

import javax.persistence.*;

@Entity
@Table(name="Empresa")
public class Empresa {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codEmpresa")
	private long codEmpresa;
	 
	@Column(name="cnpj", length=14, nullable=false)
	private String cnpj;
	 
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	 
	@Column(name="razaoSocialFantasia", length=255, nullable=false)
	private String razaoSociaFantasia;
	 
	@Column(name="cep", length=8, nullable=false)
	private String cep;
	 
	@Column(name="logradouro", length=255, nullable=false)
	private String logradouro;
	 
	@Column(name="bairro", length=100, nullable=false)
	private String bairro;
	 
	@Column(name="numeroLocal", length=10, nullable=false)
	private String numeroLocal;
	 
	@Column(name="email", length=120, nullable=false)
	private String email;
	
	@Column(name="nomeUsuario", length=40, nullable=false)
	private String nomeUsuario;
	
	@Column(name="senha", length=16, nullable=false)
	private String senha;
	 
	@Column(name="telefone", length=11)
	private String telefone;
	 
	@Column(name="nomeProprietario", length=120)
	private String nomeProprietario;
	 
	@Column(name="horarioAbertura", length=8, nullable=false)
	private String horarioAbertura;
	 
	@Column(name="horarioFechamento", length=8, nullable=false)
	private String horarioFechamento;
	 
	@Column(name="diasAberto", length=60, nullable=false)
	private String diasAberto;
	 
	@Column(name="statusEmpresa", nullable=false)
	private int statusEmpresa;

	
	
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

	public String getRazaoSociaFantasia() {
		return razaoSociaFantasia;
	}

	public void setRazaoSociaFantasia(String razaoSociaFantasia) {
		this.razaoSociaFantasia = razaoSociaFantasia;
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

	public String getNumeroEstab() {
		return numeroLocal;
	}

	public void setNumeroEstab(String numeroLocal) {
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

	public String getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public String getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(String horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public String getDiasAberto() {
		return diasAberto;
	}

	public void setDiasAberto(String diasAberto) {
		this.diasAberto = diasAberto;
	}

	public int getStatusEmpresa() {
		return statusEmpresa;
	}

	public void setStatusEmpresa(int statusEmpresa) {
		this.statusEmpresa = statusEmpresa;
	}

}
 
