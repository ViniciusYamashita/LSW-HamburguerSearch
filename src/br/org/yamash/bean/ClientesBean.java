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
	
	public void listarCadastro() {
		try {
			String valor = facesUntil.getParam("codCliente");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				
				ClientesDAO cd = new ClientesDAO();
				cliente = cd.ListarPorEntidade(codigo);
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Carregar o cadastro do Cliente!");
		}
	}
	
	
	public void salvar() {
		
		ClientesDAO cd = new ClientesDAO();
		cliente.setStatusCliente(true);
		cd.salvar(cliente);
		
		facesUntil.adicionarMsgInfo("Cliente salvo com sucesso");
		
		cliente = new Clientes();
	}
	
	public void alterarStatus(Clientes cli) {
		try {
			ClientesDAO cd = new ClientesDAO();
			cd.alterar(cli);
			
			facesUntil.adicionarMsgInfo("Situação do Cliente salvo com sucesso");
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar a situação do Cliente. Favor contatar o administrador do sistema!");
		}
	}
	
	public void alterar() {
		try {
			ClientesDAO cd = new ClientesDAO();
			cd.alterar(cliente);
			
			facesUntil.adicionarMsgInfo("Cliente alterado com sucesso");
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar o Cliente. Favor contatar o administrador do sistema!");
		}
	}
	
}
