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
	
	public void listarCadastro() {
		try {
			String valor = facesUntil.getParam("codEmpresa");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				
				EmpresaDAO fd = new EmpresaDAO();
				empresa = fd.ListarPorEntidade(codigo);
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Carregar o cadastro do Empresa!");
		}
	}

	public void salvar() {
		try {
			EmpresaDAO fd = new EmpresaDAO();
			empresa.setSenha("123");
			empresa.setValidado(false);
			empresa.setStatusEmpresa(false);
			empresa.setNomeUsuario("321");

			fd.salvar(empresa);

			facesUntil.adicionarMsgInfo("Empresa salva com sucesso");

			empresa = new Empresa();
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Salvar Empresa!. Contate o Administrador do sistema!");
		}
	}
	
	public void alterar() {
		try {
			EmpresaDAO fd = new EmpresaDAO();
			fd.alterar(empresa);
			
			facesUntil.adicionarMsgInfo("Empresa alterado com sucesso");
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar o Empresa. Favor contatar o administrador do sistema!");
		}
	}
	
	public void alterarStatus(Empresa empresa) {
		try {
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresaDAO.alterar(empresa);
			
			facesUntil.adicionarMsgInfo("Empresa Validada!");
			
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Alterar a situação da Empresa. Favor contatar o administrador do sistema!");
		}
	}

}
