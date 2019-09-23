package br.ufc.persistencia;

public class Redacao {

	private String status;
	private String notaFinal;
	private NotasRedacao notasRedacao;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}

	public NotasRedacao getNotasRedacao() {
		return notasRedacao;
	}

	public void setNotasRedacao(NotasRedacao notasRedacao) {
		this.notasRedacao = notasRedacao;
	}

	@Override
	public String toString() {
		return "Redacao [status=" + status + ", notaFinal=" + notaFinal + ", notasRedacao=" + notasRedacao + "]";
	}

}
