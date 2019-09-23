package br.ufc.persistencia.enums;

public enum PresencaProva {

	FALTOU(0, "Faltou à prova"), 
	PRESENTE(1, "Presente na prova"), 
	ELIMINADO(2, "Eliminado na prova");
	
	private int index;
	private String descricao;
	
	private PresencaProva(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static PresencaProva byIndex(String dataIndex) {
		Integer index = Integer.valueOf(dataIndex);
		for (PresencaProva n : PresencaProva.values()) {
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
