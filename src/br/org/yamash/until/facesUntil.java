package br.org.yamash.until;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class facesUntil {
	public static void adicionarMsgInfo(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);
	}

	public static void adicionarMsgErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);
	}
	
	public static String getParam (String nome) {
		FacesContext facesContext  = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		Map<String, String> parametros = externalContext.getRequestParameterMap();
		String value = parametros.get(nome);
		
		return value;
	}
	
	public static Object getUserSession () {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Object usuarioLogado = (Object) context.getSessionMap().get("autenticacaoBean");
		return usuarioLogado;
	}

}
