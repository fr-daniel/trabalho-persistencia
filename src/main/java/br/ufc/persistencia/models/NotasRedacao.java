package br.ufc.persistencia.models;

public class NotasRedacao {

	private String competencia_1;
	private String competencia_2;
	private String competencia_3;
	private String competencia_4;
	private String competencia_5;

	public String getCompetencia_1() {
		return competencia_1;
	}

	public void setCompetencia_1(String competencia_1) {
		this.competencia_1 = competencia_1;
	}

	public String getCompetencia_2() {
		return competencia_2;
	}

	public void setCompetencia_2(String competencia_2) {
		this.competencia_2 = competencia_2;
	}

	public String getCompetencia_3() {
		return competencia_3;
	}

	public void setCompetencia_3(String competencia_3) {
		this.competencia_3 = competencia_3;
	}

	public String getCompetencia_4() {
		return competencia_4;
	}

	public void setCompetencia_4(String competencia_4) {
		this.competencia_4 = competencia_4;
	}

	public String getCompetencia_5() {
		return competencia_5;
	}

	public void setCompetencia_5(String competencia_5) {
		this.competencia_5 = competencia_5;
	}

	@Override
	public String toString() {
		return "NotasRedacao [competencia_1=" + competencia_1 + ", competencia_2=" + competencia_2 + ", competencia_3="
				+ competencia_3 + ", competencia_4=" + competencia_4 + ", competencia_5=" + competencia_5 + "]";
	}

}
