package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.PortariaDaoImpl;
import br.com.fiap.entity.Portaria;
import br.com.fiap.service.GenericService;

public class PortariaServiceImpl extends GenericService<Portaria, Long>{

	private static PortariaServiceImpl instance = null;
	
	private PortariaDaoImpl portariaDao;
	
	private PortariaServiceImpl() {
		this.portariaDao = PortariaDaoImpl.getInstance();
	}
	
	public static PortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new PortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Portaria instance) {
		try {
			portariaDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
	}

	@Override
	public void atualizar(Portaria instance) {
		try {
			portariaDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
	}

	@Override
	public void remover(Long id) {
		try {
			portariaDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
		
	}

	@Override
	public Portaria obter(Long id) {
		Portaria portaria = null;
		
		try {
			portariaDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
		
		return portaria;
	}

	@Override
	public List<Portaria> listar() {
		List<Portaria> portarias = null;
		
		try {
			portarias = portariaDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}	
		
		return portarias;
	}

}
