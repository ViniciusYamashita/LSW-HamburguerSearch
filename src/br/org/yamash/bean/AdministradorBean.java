package br.org.yamash.bean;

import java.text.SimpleDateFormat;
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
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        
    }
	 public void click() {
		PrimeFaces.current().ajax().update("form:display");
	        PrimeFaces.current().executeScript("PF('dlg').show()");
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
	public void listarFabricantes() {
		try {
			AdministradorDAO fd = new AdministradorDAO();
			administradores = fd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Administradores!");
		}
	}
	
	public void salvar() {
		
		AdministradorDAO fd = new AdministradorDAO();
		fd.salvar(administrador);
		
		facesUntil.adicionarMsgInfo("Administrador salvo com sucesso");
		
		administrador=new Administrador();
	}

}
