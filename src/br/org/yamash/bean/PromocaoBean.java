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

import br.org.yamash.dao.PromocaoDAO;
import br.org.yamash.domain.Promocao;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class PromocaoBean {
	
	private Promocao promocao = new Promocao();
	private List<Promocao> promocoes;
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
	
	public void click() {
		PrimeFaces.current().ajax().update("form:display");
		PrimeFaces.current().executeScript("PF('dlg').show()");
	}
	
	public Promocao getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	public List<Promocao> getPromocoes() {
		return promocoes;
	}
	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}
	
	@PostConstruct
	public void listarPromocoes() {
		try {
			PromocaoDAO pd = new PromocaoDAO();
			promocoes = pd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Promoções!");
		}
	}
	
	public void salvar() {
		try {
			PromocaoDAO pd = new PromocaoDAO();
			pd.salvar(promocao);
			
			facesUntil.adicionarMsgInfo("Promoção salva com sucesso");
			
			promocao = new Promocao();
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Salvar promoção. Contate o Administrador do sistema!");
		}	
	}
	
	public void deletar(Promocao promo) {
		try {
			PromocaoDAO promoDAO = new PromocaoDAO();
			promoDAO.deletar(promo);

			facesUntil.adicionarMsgInfo("Promoção excluida com sucesso");
		}catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao excluir o Promoção!.");
		}
	}
	
}
