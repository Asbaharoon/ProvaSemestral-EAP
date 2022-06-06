package br.com.fiap.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fiap.entity.Visitante;

public class VisitanteDaoImpl extends HibernateGenericDao<Visitante, Long>{

	private static VisitanteDaoImpl instance = null;
	
	private VisitanteDaoImpl() {
		super(Visitante.class);
	}
	
	public static VisitanteDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new VisitanteDaoImpl();
		}
		
		return instance;
	}
	
	public List<Visitante> pesquisar(String nome, String cpf, LocalDate dataCadastro, 
			EntityManager entityManager) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);
		
		Root<Visitante> visitante = criteriaQuery.from(Visitante.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (nome != null) {
			Predicate predicate = builder.like(
					builder.upper(visitante.get("nome")), "%" + nome.toUpperCase() + "%");
			predicates.add(predicate);
		}
		
		if (cpf != null) {
			Predicate predicate = builder.equal(visitante.get("cpf"), cpf);
			predicates.add(predicate);
		}
		
		if (dataCadastro != null) {
			Predicate predicate = builder.greaterThanOrEqualTo(
					visitante.get("dataCadastro"), dataCadastro);
			predicates.add(predicate);
		}
		
		criteriaQuery.select(visitante);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}
}
