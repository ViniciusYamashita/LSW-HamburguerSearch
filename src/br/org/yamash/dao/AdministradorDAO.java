package br.org.yamash.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Administrador;
import br.org.yamash.until.HibernateUtil;

public class AdministradorDAO extends BaseDAO<Administrador> {
	
	public static Administrador autenticar (String cpf, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Administrador admin = null;
		
		try {
			Query consulta = sessao.getNamedQuery("administrador.autenticar");
			consulta.setString("cpf", cpf);
			consulta.setString("senha", senha);
			
			admin = (Administrador) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		
		return admin;
	}
}
