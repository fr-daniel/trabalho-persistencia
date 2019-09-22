package br.ufc.persistencia;

public enum Sexo {

	FEMININO("F", "Feminino"), 
	MASCULINO("M", "Masculino");
	
	private String index;
	private String descricao;
	
	private Sexo(String index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static Sexo byIndex(String dataIndex) {
		for (Sexo n : Sexo.values()) {
			if (n.index.equals(dataIndex)) {
				return n;
			}
		}
		return null;

	}
	
	public String getDescricao() {
		return descricao;
	}
	   
}
