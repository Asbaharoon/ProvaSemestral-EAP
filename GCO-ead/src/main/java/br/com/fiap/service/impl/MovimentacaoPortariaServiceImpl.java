package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.MovimentacaoPortariaDaoImpl;
import br.com.fiap.entity.MovimentacaoPortaria;
import br.com.fiap.service.GenericService;

public class MovimentacaoPortariaServiceImpl extends GenericService<MovimentacaoPortaria, Long>{

	private static MovimentacaoPortariaServiceImpl instance = null;
	
	private MovimentacaoPortariaDaoImpl movimentacaoDao;
	
	private MovimentacaoPortariaServiceImpl() {
		this.movimentacaoDao = MovimentacaoPortariaDaoImpl.getInstance();
	}
	
	public static MovimentacaoPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new MovimentacaoPortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(MovimentacaoPortaria instance) {
		try {
			movimentacaoDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void atualizar(MovimentacaoPortaria instance) {
		try {
			movimentacaoDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}				
	}

	@Override
	public void remover(Long id) {
		try {
			movimentacaoDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}		
		
	}

	@Override
	public MovimentacaoPortaria obter(Long id) {
		MovimentacaoPortaria movimentacaoPortaria = null;
		
		try {
			movimentacaoPortaria = movimentacaoDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacaoPortaria;
	}

	@Override
	public List<MovimentacaoPortaria> listar() {
		List<MovimentacaoPortaria> movimentacaoPortarias = null;
		
		try {
			movimentacaoPortarias = movimentacaoDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacaoPortarias;
	}
	
	public List<MovimentacaoPortaria> listarTipo(String tipo) {
		List<MovimentacaoPortaria> movimentacoes = null;
		
		try {
			movimentacoes = movimentacaoDao.listarPorTipo(tipo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacoes;
	}

}
