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

import br.org.yamash.dao.EmpresaDAO;
import br.org.yamash.domain.Empresa;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class EmpresaBean {

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

	private Empresa empresa = new Empresa();
	private List<Empresa> empresas;

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresa(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@PostConstruct
	public void listarEmpresas() {
		try {
			EmpresaDAO fd = new EmpresaDAO();
			empresas = fd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar as Empresas!");
		}
	}

	
	public void salvar() {

		EmpresaDAO fd = new EmpresaDAO();
		empresa.setSenha("123");
		empresa.setStatusEmpresa(1);
		empresa.setNomeUsuario("321");
		
		fd.salvar(empresa);

		facesUntil.adicionarMsgInfo("Empresa salva com sucesso");

		empresa = new Empresa();
	}

}
