package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_movimentacao_portaria")
@SequenceGenerator(name = "movimentacaoPortaria", sequenceName = "SQ_T_GCO_MOVIMENTACAO_PORTARIA", allocationSize = 1) 
public class MovimentacaoPortaria implements Serializable {
	
	private static final long serialVersionUID = -1892917407805500091L;

	public MovimentacaoPortaria() {
		
	}

	public MovimentacaoPortaria(String tipoMovimentacao, LocalDateTime dataMovimentacao, Portaria portaria,
			Visitante visitante, FuncPortaria funcPortaria) {
		super();
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataMovimentacao = dataMovimentacao;
		this.portaria = portaria;
		this.visitante = visitante;
		this.funcPortaria = funcPortaria;
	}

	@Id
	@Column(name = "id_movimentacaoPortaria")
	@GeneratedValue(generator = "movimentacaoPortaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "tp_movimentacao", length = 1, nullable = false)
	private String tipoMovimentacao;
	
	@Column(name = "dt_movimentacao", nullable = false)
	private LocalDateTime dataMovimentacao;
	
	@ManyToOne
	@JoinColumn(name = "id_portaria")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "id_visitante")
	private Visitante visitante;
	
	@ManyToOne
	@JoinColumn(name = "id_funcPortaria")
	private FuncPortaria funcPortaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public FuncPortaria getFuncPortaria() {
		return funcPortaria;
	}

	public void setFuncPortaria(FuncPortaria funcPortaria) {
		this.funcPortaria = funcPortaria;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipoMovimentacao()
			+ "\nData: " + this.getDataMovimentacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
			+ "\nPortaria: " + this.getPortaria().getNomePortaria()
			+ "\nVisitante: " + this.getVisitante().getNome()
			+ "\nFuncionario Portaria: " + this.getFuncPortaria().getNomeFuncionario();
	}

}
