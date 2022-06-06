package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.MovimentacaoPortaria;

public class MovimentacaoPortariaDaoImpl extends HibernateGenericDao<MovimentacaoPortaria, Long> {

	private static MovimentacaoPortariaDaoImpl instance = null;
	
	private MovimentacaoPortariaDaoImpl() {
		super(MovimentacaoPortaria.class);
	}
	
	public static MovimentacaoPortariaDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new MovimentacaoPortariaDaoImpl();
		}
		
		return instance;
	}
	
	public List<MovimentacaoPortaria> listarPorTipo(String tipo, EntityManager entityManager) {
		String jpql = "SELECT m FROM MovimentacaoPortaria m WHERE m.tipoMovimentacao = :tipo";
		
		TypedQuery<MovimentacaoPortaria> consulta = entityManager.createQuery(jpql, MovimentacaoPortaria.class);
		consulta.setParameter("tipo", tipo);
		
		return consulta.getResultList();
	}
}
