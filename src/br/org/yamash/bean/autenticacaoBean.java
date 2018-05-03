package br.org.yamash.bean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import br.org.yamash.domain.Administrador;

@ManagedBean
@SessionScoped
public class autenticacaoBean {
	
	private Administrador adminLogado;
	
	public Administrador getAdminLogado() {
		return adminLogado;
	}
	
	public void setAdminLogado(Administrador adminLogado) {
		this.adminLogado = adminLogado;
	}
	
	@PostConstruct
	public void iniciar() {
		adminLogado = new Administrador();
	}

}
