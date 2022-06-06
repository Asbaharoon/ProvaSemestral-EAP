package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.CondominioDaoImpl;
import br.com.fiap.entity.Condominio;
import br.com.fiap.service.GenericService;

public class CondominioServiceImpl extends GenericService<Condominio, Long>{

	private static CondominioServiceImpl instance = null;
	
	private CondominioDaoImpl condominioDao;
	
	private CondominioServiceImpl() {
		this.condominioDao = CondominioDaoImpl.getInstance();
	}
	
	public static CondominioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CondominioServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Condominio instance) {
		try {
			condominioDao.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public void atualizar(Condominio instance) {
		try {
			condominioDao.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public void remover(Long id) {
		try {
			condominioDao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}			
	}

	@Override
	public Condominio obter(Long id) {
		Condominio condominio = null;
		
		try {
			condominio = condominioDao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return condominio;
	}

	@Override
	public List<Condominio> listar() {
		List<Condominio> condominios = null;
		
		try {
			condominios = condominioDao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return condominios;
	}

}
