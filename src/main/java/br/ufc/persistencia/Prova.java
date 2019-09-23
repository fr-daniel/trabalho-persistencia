package br.ufc.persistencia;

public class Prova {

	private String descricao;
	private String nota;
	private String presenca;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	@Override
	public String toString() {
		return "Prova [descricao=" + descricao + ", nota=" + nota + ", presenca=" + presenca + "]";
	}

}
