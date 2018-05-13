package br.org.yamash.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Empresa;
import br.org.yamash.until.HibernateUtil;

public class EmpresaDAO extends BaseDAO<Empresa>{
	
	public static Empresa autenticar(String nomeUsuario, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Empresa emp = null;

		try {
			Query consulta = sessao.getNamedQuery("empresa.autenticar");
			consulta.setString("nomeUsuario", nomeUsuario);
			consulta.setString("senha", senha);

			emp = (Empresa) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return emp;
	}
}
