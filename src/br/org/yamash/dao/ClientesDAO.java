package br.org.yamash.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Clientes;
import br.org.yamash.until.HibernateUtil;

public class ClientesDAO extends BaseDAO<Clientes> {
	
	public static Clientes autenticar(String email, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Clientes cli = null;

		try {
			Query consulta = sessao.getNamedQuery("cliente.autenticar");
			consulta.setString("email", email);
			consulta.setString("senha", senha);

			cli = (Clientes) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return cli;
	}

}
