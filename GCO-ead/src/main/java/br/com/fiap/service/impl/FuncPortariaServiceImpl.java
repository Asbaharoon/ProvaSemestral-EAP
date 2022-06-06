package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.FuncPortariaDaoImpl;
import br.com.fiap.entity.FuncPortaria;
import br.com.fiap.service.GenericService;

public class FuncPortariaServiceImpl extends GenericService<FuncPortaria, Long>{

	private static FuncPortariaServiceImpl instance = null;
	
	private FuncPortariaDaoImpl funcPortariaDao;
	
	private FuncPortariaServiceImpl() {
		this.funcPortariaDao = FuncPortariaDaoImpl.getInstance();
	}
	
	public static FuncPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncPortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(FuncPortaria instance) {
		try {
			funcPortariaDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
	}

	@Override
	public void atualizar(FuncPortaria instance) {
		try {
			funcPortariaDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public void remover(Long id) {
		try {
			funcPortariaDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public FuncPortaria obter(Long id) {
		FuncPortaria funcPortaria = null;
		
		try {
			funcPortaria = funcPortariaDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return funcPortaria;
	}

	@Override
	public List<FuncPortaria> listar() {
		List<FuncPortaria> funcsPortaria = null;
		
		try {
			funcsPortaria = funcPortariaDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return funcsPortaria;
	}

}
