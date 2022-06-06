package br.com.fiap.dao.impl;

import br.com.fiap.entity.Portaria;

public class PortariaDaoImpl extends HibernateGenericDao<Portaria, Long> {

	private static PortariaDaoImpl instance = null;
	
	private PortariaDaoImpl() {
		super(Portaria.class);
	}
	
	public static PortariaDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new PortariaDaoImpl();
		}
		
		return instance;
	}
}
