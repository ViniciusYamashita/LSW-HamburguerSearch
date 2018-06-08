package br.org.yamash.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.org.yamash.dao.AdministradorDAO;
import br.org.yamash.dao.ClientesDAO;
import br.org.yamash.dao.EmpresaDAO;
import br.org.yamash.domain.Administrador;
import br.org.yamash.domain.Clientes;
import br.org.yamash.domain.Empresa;
import br.org.yamash.domain.Usuario;
import br.org.yamash.until.facesUntil;

@ManagedBean
@SessionScoped
public class autenticacaoBean {
	
	private Usuario usuario;
	
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void entrar() {
		try {
			
			Administrador adminlogado;
			Empresa empresalogada;
			Clientes clientelogado;
			
			if ((adminlogado = AdministradorDAO.autenticar(usuario.getLogin(), usuario.getSenha())) != null) {
				facesUntil.adicionarMsgInfo("Administrador logado com sucesso");
				usuario.setCodigo(adminlogado.getCodAdmin());
				
			} else if ((empresalogada = EmpresaDAO.autenticar(usuario.getLogin(), usuario.getSenha())) != null) {
				facesUntil.adicionarMsgInfo("Empresa logado com sucesso");
				usuario.setCodigo(empresalogada.getCodEmpresa());
				
			} else if ((clientelogado = ClientesDAO.autenticar(usuario.getLogin(), usuario.getSenha())) != null) {
				facesUntil.adicionarMsgInfo("Cliente logado com sucesso");
				usuario.setCodigo(clientelogado.getCodCliente());
				
			} else {
				facesUntil.adicionarMsgErro("Login ou Senha inválidos.");
				
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Erro ao tentar autenticar no sistema:" + ex.getMessage());
		}
	}

}
