package br.com.fiap.gs1.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idViagem;
	@Column(nullable = false)
	@DateTimeFormat()
	private String dataDecolagem;
	@Column(nullable = false)
	private int duracaoEstadia;
	@Column(nullable = false)
	private int qtdAssentos;
	@Column(nullable = false)
	//@Pattern(regexp = "[a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z]-\\d\\d\\d\\d]")
	private String modeloNave;
	@Column(nullable = false)
	private String primeiroComandante;
	@Column(nullable = false)
	//@Pattern(regexp = "[a-zA-Z][a-zA-Z][a-zA-Z]-\\d\\d\\d\\d-[a-zA-Z][0-9]+[a-zA-Z]")
	private String matriculaPrimeiroComandante;
	@Column(nullable = false)
	private String segundoComandante;
	@Column(nullable = false)
	private String matriculaSegundoComandante;
	
	
	private String dataRetornoTerra;

	
	public Viagem() {
	}
	
	public Viagem(int idViagem, String dataDecolagem, int duracaoEstadia, int qtdAssentos, String modeloNave,
			String primeiroComandante, String matriculaPrimeiroComandante, String segundoComandante,
			String matriculaSegundoComandante, String dataRetornoTerra) {
		super();
		this.idViagem = idViagem;
		this.dataDecolagem = dataDecolagem;
		this.duracaoEstadia = duracaoEstadia;
		this.qtdAssentos = qtdAssentos;
		this.modeloNave = modeloNave;
		this.primeiroComandante = primeiroComandante;
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
		this.segundoComandante = segundoComandante;
		this.matriculaSegundoComandante = matriculaSegundoComandante;
		this.dataRetornoTerra = dataRetornoTerra;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public String getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(String dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public int getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(int duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public int getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(int qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public String getModeloNave() {
		return modeloNave;
	}

	public void setModeloNave(String modeloNave) {
		this.modeloNave = modeloNave;
	}

	public String getPrimeiroComandante() {
		return primeiroComandante;
	}

	public void setPrimeiroComandante(String primeiroComandante) {
		this.primeiroComandante = primeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getSegundoComandante() {
		return segundoComandante;
	}

	public void setSegundoComandante(String segundoComandante) {
		this.segundoComandante = segundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}

	public String getDataRetornoTerra() {
		return dataRetornoTerra;
	}

	public void setDataRetornoTerra(String dataRetornoTerra) {
		this.dataRetornoTerra = dataRetornoTerra;
	}
	
	
	
	
}
