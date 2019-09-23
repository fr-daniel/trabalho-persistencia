package br.ufc.persistencia.enums;

public enum Raca {

	NAO_DECLARADO(0, "Não declarado"), 
	BRANCA(1, "Branca"), 
	PRETA(2, "Preta"), 
	PARDA(3, "Parda"), 
	AMARELA(4, "Amarela"),
	INDIGENA(5, "Indígena");
	
	private int index;
	private String descricao;
	
	private Raca(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static Raca byIndex(String dataIndex) {
		Integer index = Integer.valueOf(dataIndex);
		for (Raca n : Raca.values()) {
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
