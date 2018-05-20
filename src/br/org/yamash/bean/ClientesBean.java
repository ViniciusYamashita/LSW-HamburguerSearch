package br.org.yamash.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.yamash.dao.ClientesDAO;
import br.org.yamash.domain.Clientes;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class ClientesBean {
	
	private Clientes cliente = new Clientes();
	private List<Clientes> clientes;
	
	
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public List<Clientes> getClientes() {
		return clientes;
	}
	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}
	
	@PostConstruct
	public void listarClientes() {
		try {
			ClientesDAO cd = new ClientesDAO();
			clientes = cd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Clientes!");
		}
	}
	
	public void salvar() {
		
		ClientesDAO cd = new ClientesDAO();
		cliente.setStatusCliente(1);
		cd.salvar(cliente);
		
		facesUntil.adicionarMsgInfo("Cliente salvo com sucesso");
		
		cliente = new Clientes();
	}
	
	
}
