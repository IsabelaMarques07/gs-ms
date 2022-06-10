package br.com.fiap.gs1.dtos;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.fiap.gs1.models.Viagem;

public class ViagemDTO {
		
		@NotNull
		private String dataDecolagem;
		@NotNull
		private int duracaoEstadia;
		@NotNull
		private int qtdAssentos;
		@NotNull
		@NotBlank
		private String modeloNave;
		@NotNull
		@NotBlank
		private String primeiroComandante;
		@NotNull
		@NotBlank
		private String matriculaPrimeiroComandante;
		@NotNull
		@NotBlank
		private String segundoComandante;
		@NotNull
		@NotBlank
		private String matriculaSegundoComandante;
		@NotNull
		private String dataRetornoTerra;


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
		
		public void fromViagem(Viagem viagem) {
			this.dataDecolagem = viagem.getDataDecolagem();
			this.duracaoEstadia = viagem.getDuracaoEstadia();
			this.qtdAssentos = viagem.getQtdAssentos();
			this.modeloNave = viagem.getModeloNave();
			this.primeiroComandante = viagem.getPrimeiroComandante();
			this.matriculaPrimeiroComandante = viagem.getMatriculaPrimeiroComandante();
			this.segundoComandante = viagem.getSegundoComandante();
			this.matriculaSegundoComandante = viagem.getMatriculaSegundoComandante();			
			
		}
		
}
