package br.ufc.persistencia.models;

import java.util.ArrayList;
import java.util.List;

public class Candidato {

	private String inscricao;
	private Integer idade;
	private String sexo;
	private String nacionalidade;
	private String raca;
	private String estado_civil;
	
	private Redacao redacao;

	private List<Prova> provas;

	public Candidato() {
		this.provas = new ArrayList<Prova>();
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	
	public void addProva(Prova prova) {
		this.provas.add(prova);
	}

	public Redacao getRedacao() {
		return redacao;
	}

	public void setRedacao(Redacao redacao) {
		this.redacao = redacao;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	@Override
	public String toString() {
		return "Candidato [inscricao=" + inscricao + ", idade=" + idade + ", sexo=" + sexo + ", nacionalidade="
				+ nacionalidade + ", raca=" + raca + ", estado_civil=" + estado_civil + ", redacao=" + redacao
				+ ", provas=" + provas + "]";
	}	
	
}
