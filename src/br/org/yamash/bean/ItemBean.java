package br.org.yamash.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.org.yamash.dao.EmpresaDAO;
import br.org.yamash.dao.ItemDAO;
import br.org.yamash.domain.Empresa;
import br.org.yamash.domain.Item;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class ItemBean {

	private Item item = new Item();
	private List<Item> itens;
	private List<Empresa> empresas;
	
	public void listarEmpresas() {
		try {
			EmpresaDAO fd = new EmpresaDAO();
			empresas = fd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Itens!");
		}
	}

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

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@PostConstruct
	public void listarItens() {
		try {
			ItemDAO fd = new ItemDAO();
			itens = fd.Listar();
			
			EmpresaDAO fd1 = new EmpresaDAO();
			empresas = fd1.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Itens!");
		}
	}

	public void salvar() {
		try {
			ItemDAO id = new ItemDAO();
			item.setStatusItem(true);
			item.setFoto("Sem foto");;
			id.salvar(item);

			facesUntil.adicionarMsgInfo("Item salvo com sucesso");
			
			item = new Item();
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Salvar o Item. Favor contate o administrador do sistema!");
		}
	}
	
	public void alterarStatus(Item item) {
		try {
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.alterar(item);
			
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar a situação do Item. Favor contatar o administrador do sistema!");
		}
	}

}
