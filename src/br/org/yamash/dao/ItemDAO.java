package br.org.yamash.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Item;
import br.org.yamash.until.HibernateUtil;

public class ItemDAO extends BaseDAO<Item> {

	public List<Item> filtrarPorEmpresa(Long codigo) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = s.getNamedQuery("item.listarPorEmpresa");
			query.setLong("codEmpresa", codigo);
			
			List<Item> rs = query.list();
			List<Item> rt = rs;
			return rs;
			
		} catch (RuntimeException ex) {
			throw ex;
			
		} finally {
			s.close();
		}
	}

}
