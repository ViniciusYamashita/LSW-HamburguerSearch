package br.org.yamash.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ItemPromocao")
public class ItemPromocao {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codItemPromocao")
	private long codItemPromocao;
	 
	@NotNull(message="O campo 'Item' é obrigatório.")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codItem", referencedColumnName="codItem")
	private Item codItem;
	 
	@NotNull(message="O campo 'Promoção' é obrigatório.")
	@ManyToOne(fetch=FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItem == null) ? 0 : codItem.hashCode());
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
		ItemPromocao other = (ItemPromocao) obj;
		if (codItem == null) {
			if (other.codItem != null)
				return false;
		} else if (!codItem.equals(other.codItem))
			return false;
		return true;
	}
}
 
