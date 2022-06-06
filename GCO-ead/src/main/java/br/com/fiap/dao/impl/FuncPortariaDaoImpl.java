package br.com.fiap.dao.impl;

import br.com.fiap.entity.FuncPortaria;

public class FuncPortariaDaoImpl extends HibernateGenericDao<FuncPortaria, Long> {

	private static FuncPortariaDaoImpl instance = null;
	
	private FuncPortariaDaoImpl() {
		super(FuncPortaria.class);
	}
	
	public static FuncPortariaDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncPortariaDaoImpl();
		}
		
		return instance;
	}
}
