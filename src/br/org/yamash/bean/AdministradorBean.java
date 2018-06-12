package br.org.yamash.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.org.yamash.dao.AdministradorDAO;
import br.org.yamash.domain.Administrador;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class AdministradorBean {

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));

	}

	public void click() {
		PrimeFaces.current().ajax().update("form:display");
		PrimeFaces.current().executeScript("PF('dlg').show()");
	}

	public String carregarData() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String data = format.format(new Date(System.currentTimeMillis()));
		return data;
	}

	private Administrador administrador = new Administrador();
	private List<Administrador> administradores;

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@PostConstruct
	public void listarAdministrador() {
		try {
			AdministradorDAO fd = new AdministradorDAO();
			administradores = fd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Administradores!");
		}
	}
	
	public void listarCadastro() {
		try {
			String valor = facesUntil.getParam("codAdmin");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				
				AdministradorDAO adminDAO = new AdministradorDAO();
				administrador = adminDAO.ListarPorEntidade(codigo);
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Carregar o cadastro do Administrador!");
		}
	}

	public void salvar() {

		AdministradorDAO fd = new AdministradorDAO();
		administrador.setSenha("123");
		administrador.setStatusAdmin(true);
		fd.salvar(administrador);

		facesUntil.adicionarMsgInfo("Administrador salvo com sucesso");

		administrador = new Administrador();
	}
	
	public void alterar() {
		try {
			AdministradorDAO adminDAO = new AdministradorDAO();
			adminDAO.alterar(administrador);
			
			facesUntil.adicionarMsgInfo("Administrador alterado com sucesso");
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar o Administrador. Favor contatar o administrador do sistema!");
		}
	}


	public void alterarStatus(Administrador admin) {
		try {
			AdministradorDAO adminDAO = new AdministradorDAO();
			adminDAO.alterar(admin);
			
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar a situação do Adminitrador. Favor contatar o administrador do sistema!");
		}
	}
}
