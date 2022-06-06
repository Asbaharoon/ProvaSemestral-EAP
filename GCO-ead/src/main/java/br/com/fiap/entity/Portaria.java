package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "T_GCO_PORTARIA") 
@SequenceGenerator(name = "portaria", sequenceName = "SQ_T_GCO_PORTARIA", allocationSize = 1)
public class Portaria implements Serializable {

	private static final long serialVersionUID = 1L;

	public Portaria() {

	}
	
	public Portaria (String nomePortaria, Condominio condominio) {
		this.nomePortaria = nomePortaria;
		this.condominio = condominio;
	}

	public Portaria(String nomePortaria, String status, LocalDate dataInicio, LocalDate dataTermino) {
		super();
		this.nomePortaria = nomePortaria;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	@Id
	@Column(name = "id_portaria")
	@GeneratedValue(generator = "portaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nr_portaria", nullable = false)
	private int numeroPortaria;

	@Column(name = "nm_portaria", length = 20, nullable = false)
	private String nomePortaria;

	@Column(name = "st_status")
	private String status;

	@Column(name = "dt_inicio")
	private LocalDate dataInicio;

	@Column(name = "dt_termino")
	private LocalDate dataTermino;

	//Relacao
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPortaria() {
		return numeroPortaria;
	}

	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}

	public String getNomePortaria() {
		return nomePortaria;
	}

	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	@Override
	public String toString() {
		return "Portaria [numeroPortaria=" + numeroPortaria + ", nomePortaria=" + nomePortaria + ", status=" + status
				+ ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", condominio=" + condominio + "]";
	}

}
