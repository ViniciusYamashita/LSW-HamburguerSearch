package br.org.yamash.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.org.yamash.domain.Administrador;

@ManagedBean
@SessionScoped
public class autenticacaoBean {
	
	private Administrador admin;
	
	public Administrador getAdmin() {
		if (admin == null) {
			admin = new Administrador();
		}
		return admin;
	}
	
	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

}
