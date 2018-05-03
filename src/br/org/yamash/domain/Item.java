package br.org.yamash.domain;

import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codItem")
	private int codItem;
	 
	@Column(name="nome", length=80, nullable=false)
	private String nome;
	 
	@Column(name="descricao", length=500, nullable=false)
	private String descricao;
	 
	@Column(name="preco", nullable=false)
	private float preco;
	 
	@Column(name="foto", length=255, nullable=false)
	private String foto;
	 
	@Column(name="statusItem", nullable=false)
	private int statusItem;
	 
	@Column(name="situacaoItem", nullable=false)
	private boolean situacaoItem;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codEmpresa", referencedColumnName="codEmpresa")
	private Empresa codEmpresa;

	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(int statusItem) {
		this.statusItem = statusItem;
	}

	public boolean isSituacaoItem() {
		return situacaoItem;
	}

	public void setSituacaoItem(boolean situacaoItem) {
		this.situacaoItem = situacaoItem;
	}

	public Empresa getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Empresa codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	
	
	 
}
 
