package br.org.yamash.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.org.yamash.domain.Empresa;
import br.org.yamash.until.HibernateUtil;

public class EmpresaDAO extends BaseDAO<Empresa> {

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

	public Empresa listarEmpresaDona (Long codigo) {

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = s.getNamedQuery("empresa.listarEmpresa");
			query.setLong("codEmpresa", codigo);

			Empresa rs = (Empresa) query.uniqueResult();
			Empresa rt = rs;
			return rs;

		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			s.close();
		}
	}

	public List<Empresa> filtrarPorNomeEmpresa(String nome) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = s.getNamedQuery("empresa.buscarPorNomeEmpresa");
			query.setString("nome", nome);

			List<Empresa> rs = query.list();
			List<Empresa> rt = rs;
			return rs;

		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			s.close();
		}
	}
}
