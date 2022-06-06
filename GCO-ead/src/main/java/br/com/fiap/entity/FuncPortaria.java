package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_FUNC_PORTARIA")	
@SequenceGenerator(name = "funcPortaria", sequenceName = "SQ_T_GCO_FUNC_PORTARIA", allocationSize = 1)
public class FuncPortaria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public FuncPortaria () {
		
	}

	
	public FuncPortaria(String nomeFuncionario, LocalDate dataNascimento, String cpf, String rg,
			LocalDateTime dataCadastro) {
		super();
		this.nomeFuncionario = nomeFuncionario;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}



	@Id
	@Column(name = "id_func_portaria")
	@GeneratedValue(generator = "funcPortaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_funcionario", length = 20, nullable = false)
	private String nomeFuncionario;
	
	@Column(name = "dt_nasc", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "nr_cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nr_rg", nullable = false)
	private String rg;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNomeFuncionario()
			+ "\nNascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			+ "\nCPF: " + this.getCpf()
			+ "\nRG: " + this.getRg()
			+ "\nCadastro: " + this.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	

}
