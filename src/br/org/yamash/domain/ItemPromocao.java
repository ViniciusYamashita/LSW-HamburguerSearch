package br.org.yamash.domain;

import javax.persistence.*;

@Entity
@Table(name="ItemPromocao")
public class ItemPromocao {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codItemPromocao")
	private long codItemPromocao;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codItem", referencedColumnName="codItem")
	private Item codItem;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codPromocao", referencedColumnName="codPromocao")
	private Promocao codPromocao;

	
	public long getCodItemPromocao() {
		return codItemPromocao;
	}

	public void setCodItemPromocao(long codItemPromocao) {
		this.codItemPromocao = codItemPromocao;
	}

	public Item getCodItem() {
		return codItem;
	}

	public void setCodItem(Item codItem) {
		this.codItem = codItem;
	}

	public Promocao getCodPromocao() {
		return codPromocao;
	}

	public void setCodPromocao(Promocao codPromocao) {
		this.codPromocao = codPromocao;
	}
	
	
	
}
 
