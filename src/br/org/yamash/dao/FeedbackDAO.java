package br.org.yamash.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Feedback;
import br.org.yamash.until.HibernateUtil;

public class FeedbackDAO extends BaseDAO<Feedback> {

	public Integer calcularMediaItem(Long codigo) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = s.getNamedQuery("feedback.calcularMediaItem");
			query.setLong("codItem", codigo);

			Integer rs = (Integer) query.uniqueResult();
			Integer tt = rs;
			return rs;

		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			s.close();
		}
	}

}
