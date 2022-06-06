package br.com.fiap.application;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.entity.Condominio;
import br.com.fiap.entity.FuncPortaria;
import br.com.fiap.entity.MovimentacaoPortaria;
import br.com.fiap.entity.Portaria;
import br.com.fiap.entity.Visitante;
import br.com.fiap.service.impl.CondominioServiceImpl;
import br.com.fiap.service.impl.FuncPortariaServiceImpl;
import br.com.fiap.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.service.impl.PortariaServiceImpl;
import br.com.fiap.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movimentacaoService = MovimentacaoPortariaServiceImpl.getInstance();
		FuncPortariaServiceImpl funcionarioService = FuncPortariaServiceImpl.getInstance();
		
		
		Condominio condominio = new Condominio("11222333444", "Soso Beauty", "soso",  LocalDate.of(2022, 1, 1));
		condominioService.cadastrar(condominio);
		
		System.out.println("----Condominios----");
		condominioService.listar().forEach(System.out::println);
		
		System.out.println("----Visistantes----");
		visitanteService.listar().forEach(System.out::println);
		
		Portaria portaria1 = new Portaria("Principal", condominio);
		Portaria portaria2 = new Portaria("Servico", condominio);
		portariaService.cadastrar(portaria1);
		portariaService.cadastrar(portaria2);
		
		System.out.println("----Portarias----");
		portariaService.listar().forEach(System.out::println);
		
		FuncPortaria funcionario1 = funcionarioService.obter(1L);
		FuncPortaria funcionario2 = funcionarioService.obter(2L);

		Visitante visitante1 = visitanteService.obter(1L);
		Visitante visitante2 = visitanteService.obter(2L);

		
		MovimentacaoPortaria movimentacaoPortaria1 = new MovimentacaoPortaria("E",
				LocalDateTime.of(2022, 06, 01, 15, 0, 0), portaria1, visitante1, funcionario1);
		 	
		MovimentacaoPortaria movimentacaoPortaria2 = new MovimentacaoPortaria("E",
				LocalDateTime.of(2022, 06, 01, 15, 30, 0), portaria1, visitante2, funcionario1);
		
		MovimentacaoPortaria movimentacaoPortaria3 = new MovimentacaoPortaria("S",
				LocalDateTime.of(2022, 06, 01, 15, 45, 0), portaria1, visitante1, funcionario2);
		
		movimentacaoService.cadastrar(movimentacaoPortaria1);
		movimentacaoService.cadastrar(movimentacaoPortaria2);
		movimentacaoService.cadastrar(movimentacaoPortaria3);
		
		System.out.println("Movimentacao portaria");
		movimentacaoService.listar().forEach(System.out::println);

		System.out.println("Movimentacao tipo: ");
		movimentacaoService.listarTipo("S").forEach(System.out::println);
		
		System.out.println("Pesquisa com filtro");
		System.out.println("visitante filtro : maria");
		visitanteService.pesquisar(null, "222.222.222-22", null).forEach(System.out::println);;
		
		
		System.out.println("visitante filtro : data");
		visitanteService.pesquisar(null, null, LocalDate.of(2004, 05, 23)).forEach(System.out::println);;

	}
}
