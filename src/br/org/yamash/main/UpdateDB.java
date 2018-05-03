package br.org.yamash.main;

import br.org.yamash.until.HibernateUtil;

public class UpdateDB {

	public static void main(String[] args) {
		// Cria a sesão e faz um update do banco de dados
		HibernateUtil.getSessionFactory();

	}

}
