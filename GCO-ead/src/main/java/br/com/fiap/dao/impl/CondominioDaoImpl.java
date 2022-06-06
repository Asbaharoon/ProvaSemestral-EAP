package br.com.fiap.dao.impl;

import br.com.fiap.entity.Condominio;

public class CondominioDaoImpl extends HibernateGenericDao<Condominio, Long>{

	private static CondominioDaoImpl instance = null;
	
	private CondominioDaoImpl() {
		super(Condominio.class);
	}
	
	public static CondominioDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new CondominioDaoImpl();
		}
		
		return instance;
	}
}
