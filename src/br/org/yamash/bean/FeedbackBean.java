package br.org.yamash.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.yamash.converter.ClienteConverter;
import br.org.yamash.dao.ClientesDAO;
import br.org.yamash.dao.EmpresaDAO;
import br.org.yamash.dao.FeedbackDAO;
import br.org.yamash.dao.ItemDAO;
import br.org.yamash.domain.Clientes;
import br.org.yamash.domain.Empresa;
import br.org.yamash.domain.Feedback;
import br.org.yamash.domain.Item;
import br.org.yamash.domain.Usuario;
import br.org.yamash.until.facesUntil;

@ManagedBean
@ViewScoped
public class FeedbackBean {

	private Feedback feedback = new Feedback();
	private List<Feedback> feedbacks;

	private List<Empresa> empresas;
	private List<Clientes> clientes;
	private List<Item> itens;

	public Date carregarData() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String data = format.format(new Date(System.currentTimeMillis()));
		Date data2 = format.parse(data);
		return data2;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@PostConstruct
	public void listarFeedbacks() {
		try {
			FeedbackDAO fd = new FeedbackDAO();
			feedbacks = fd.Listar();

			EmpresaDAO ed = new EmpresaDAO();
			empresas = ed.Listar();

			ItemDAO id = new ItemDAO();
			itens = id.Listar();

			ClientesDAO cd = new ClientesDAO();
			clientes = cd.Listar();
		} catch (RuntimeException e) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Listar os Feedbacks!");
		}
	}

	public void listarCadastro() {
		try {
			String valor = facesUntil.getParam("codFeedback");

			if (valor != null) {
				Long codigo = Long.parseLong(valor);

				FeedbackDAO feedbackDAO = new FeedbackDAO();
				feedback = feedbackDAO.ListarPorEntidade(codigo);
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Carregar o cadastro do Administrador!");
		}
	}

	public void salvar() throws ParseException {
		try {
			// Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			FeedbackDAO fd = new FeedbackDAO();
			feedback.setDtFeedback(carregarData());
			fd.salvar(feedback);

			facesUntil.adicionarMsgInfo("Feedback salvo com sucesso");

			feedback = new Feedback();
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao Salvar o Feedback!. Contate o Administrador do sistema!");
		}
	}
	
	public void setarCliente() {
		//Usuario user =  (Usuario) facesUntil.getUserSession();
		//Clientes logado = user.getUsuarioSup();
		
		//if (logado != null) {
			//clientes = (List<Clientes>) logado;
		//}
	}

	public void alterar() {
		try {
			FeedbackDAO feedbackDAO = new FeedbackDAO();
			feedbackDAO.alterar(feedback);

			facesUntil.adicionarMsgInfo("Feedback alterado com sucesso");
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro(
					"Ocorreu um erro ao Alterar o Feedback. Favor contatar o administrador do sistema!");
		}
	}

	public void deletar(Feedback feedback) {
		try {
			FeedbackDAO feedbackDAO = new FeedbackDAO();
			feedbackDAO.deletar(feedback);

			facesUntil.adicionarMsgInfo("Feedback excluido com sucesso");
		}catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro ao excluir o Feedback!.");
		}
	}

	public void listarFeedbacksItens() {
		try {
			String valor = facesUntil.getParam("codItem");

			if (valor != null) {
				Long codigo = Long.parseLong(valor);

				FeedbackDAO feedbackDAO = new FeedbackDAO();
				feedbacks = feedbackDAO.listarFeedbackItem(codigo);
			}
		} catch (RuntimeException ex) {
			facesUntil.adicionarMsgErro("Ocorreu um erro generico ao Carregar o cadastro do Administrador!");
		}
	}
}
