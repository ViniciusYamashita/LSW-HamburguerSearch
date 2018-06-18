package br.org.yamash.dao;

import java.util.ArrayList;
import java.util.List;

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

			ArrayList<Double> rs = (ArrayList<Double>) query.list();
			int tt = rs.get(0).intValue();
			Integer rh = (tt);
			
			return rh;

		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			s.close();
		}
	}
	
	public List<Feedback> listarFeedbackItem(Long codigo){
		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = s.getNamedQuery("feedback.feedbackItens");
			query.setLong("codItem", codigo);
			
			List<Feedback> rs = query.list();
			List<Feedback> rt = rs;
			return rs;
			
		} catch (RuntimeException ex) {
			throw ex;
			
		} finally {
			s.close();
		}
	}

}
