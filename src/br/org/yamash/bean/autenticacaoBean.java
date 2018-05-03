package br.org.yamash.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.org.yamash.domain.Administrador;

@ManagedBean
@SessionScoped
public class autenticacaoBean {
	
	private Administrador adminLogado;
	
	public Administrador getAdminLogado() {
		if (adminLogado == null) {
			adminLogado = new Administrador();
		}
		return adminLogado;
	}
	
	public void setAdminLogado(Administrador adminLogado) {
		this.adminLogado = adminLogado;
	}

}
