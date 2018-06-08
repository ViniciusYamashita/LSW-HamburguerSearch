package br.org.yamash.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.yamash.dao.ItemDAO;
import br.org.yamash.dao.ItemPromocaoDAO;
import br.org.yamash.dao.PromocaoDAO;
import br.org.yamash.domain.Item;
import br.org.yamash.domain.ItemPromocao;
import br.org.yamash.domain.Promocao;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class ItemPromocaoBean {
	
	private ItemPromocao itemPromo = new ItemPromocao();
	private List<ItemPromocao> itensPromo;
	
	private List<Item> itens;
	private List<Promocao> promocoes;
	
	public ItemPromocao getItemPromo() {
		return itemPromo;
	}
	public void setItemPromo(ItemPromocao itemPromo) {
		this.itemPromo = itemPromo;
	}
	public List<ItemPromocao> getItensPromo() {
		return itensPromo;
	}
	public void setItensPromo(List<ItemPromocao> itensPromo) {
		this.itensPromo = itensPromo;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public List<Promocao> getPromocoes() {
		return promocoes;
	}
	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}
	
	
	@PostConstruct
	public void listarItensPromocao() {
		try {
			ItemPromocaoDAO itpromod = new ItemPromocaoDAO();
			itensPromo = itpromod.Listar();
			
			ItemDAO id = new ItemDAO();
			itens = id.Listar();
			
			PromocaoDAO promod = new PromocaoDAO();
			promocoes = promod.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Itens!");
		}
	}

	public void salvar() {
		try {
			ItemPromocaoDAO promod = new ItemPromocaoDAO();
			promod.salvar(itemPromo);

			facesUntil.adicionarMsgInfo("Item salvo com sucesso");

			itemPromo = new ItemPromocao();
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Salvar o Item da Promoção!. Contate o administrador do sistema!");
		}	
	}
	
	public void deletar(ItemPromocao itemPromo) {
		try {
			ItemPromocaoDAO itemPromoDAO = new ItemPromocaoDAO();
			itemPromoDAO.deletar(itemPromo);

			facesUntil.adicionarMsgInfo("Item da Promoção excluido com sucesso");
		}catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao excluir o Item da Promoção!");
		}
	}
	
}
