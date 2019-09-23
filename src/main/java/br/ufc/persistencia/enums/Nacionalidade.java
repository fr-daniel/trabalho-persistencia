package br.ufc.persistencia.enums;

public enum Nacionalidade {

	NAO_INFORMADO(0, "Não informado"), 
	BRASILEIRO(1, "Brasileiro(a)"), 
	NATURALIZADO(2, "Brasileiro(a) Naturalizado(a)"), 
	ESTRANGEIRO(3, "Estrangeiro(a)"), 
	BRASILEIRO_NASCIDO_EXTERIOR(4, "Brasileiro(a) Nato(a), nascido(a) no exterior");
	
	private int index;
	private String descricao;
	
	private Nacionalidade(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static Nacionalidade byIndex(String dataIndex) {
		Integer index = Integer.valueOf(dataIndex);
		for (Nacionalidade n : Nacionalidade.values()) {
			if (n.index == index) {
				return n;
			}
		}
		return null;

	}
	
	public String getDescricao() {
		return descricao;
	}
	   
}
