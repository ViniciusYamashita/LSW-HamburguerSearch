package br.org.yamash.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.org.yamash.until.HibernateUtil;

public class BaseDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	public BaseDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	// Salvar Entidade, recebe por parametro o  fabricante
	public void salvar(Entidade ent) {
		
		//Abre uma seção 
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		// Comando de tentativa de salvar dado
		try {
			t = s.beginTransaction();
			s.save(ent);
			t.commit();
			
		} catch (RuntimeException ex) {
			t.rollback();
			throw ex;
			
		} finally {
			s.close();
		}
		
	}
	
	public List<Entidade> Listar(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria query = s.createCriteria(classe);
			
			List<Entidade> rs = query.list();
			return rs;
			
		} catch (RuntimeException ex) {
			throw ex;
			
		} finally {
			s.close();
		}
	}
	
	public Entidade ListarPorEntidade(Long codigo){
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria query = s.createCriteria(classe);
			query.add(Restrictions.idEq(codigo));
			Entidade ent = (Entidade) query.uniqueResult();
			return ent;
			
		} catch (RuntimeException ex) {
			throw ex;
			
		} finally {
			s.close();
		}
	}
	
	public void alterar (Entidade ent) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			s.update(ent);
			t.commit();
			
		} catch (RuntimeException ex) {
			t.rollback();
			throw ex;
			
		} finally {
			s.close();
		}
		
	}
	
	public void deletar (Entidade ent) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			s.delete(ent);
			t.commit();
			
		} catch (RuntimeException ex) {
			t.rollback();
			throw ex;
			
		} finally {
			s.close();
		}
		
	}
	

}
