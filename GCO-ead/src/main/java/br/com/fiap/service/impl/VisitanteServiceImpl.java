package br.com.fiap.service.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.dao.impl.VisitanteDaoImpl;
import br.com.fiap.entity.Visitante;
import br.com.fiap.service.GenericService;

public class VisitanteServiceImpl extends GenericService<Visitante, Long>{

	private static VisitanteServiceImpl instance = null;
	
	private VisitanteDaoImpl visitanteDao;
	
	private VisitanteServiceImpl() {
		this.visitanteDao = VisitanteDaoImpl.getInstance();
	}
	
	public static VisitanteServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new VisitanteServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Visitante instance) {
		try {
			visitanteDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public void atualizar(Visitante instance) {
		try {
			visitanteDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public void remover(Long id) {
		try {
			visitanteDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public Visitante obter(Long id) {
		Visitante visitante = null;
		
		try {
			visitante = visitanteDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitante;
	}

	@Override
	public List<Visitante> listar() {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}
	
	public List<Visitante> pesquisar(String nome, String cpf, LocalDate dataCadastro) {
		List<Visitante> visitantes = null;
		
		try {
			visitantes = visitanteDao.pesquisar(nome, cpf, dataCadastro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return visitantes;
	}

	

}
