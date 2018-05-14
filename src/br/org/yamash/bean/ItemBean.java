package br.org.yamash.bean;

import java.util.List;

import br.org.yamash.domain.Item;

public class ItemBean {
	
	private Item item = new Item();
	private List<Item> itens;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}
