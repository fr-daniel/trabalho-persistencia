package br.ufc.persistencia.enums;

public enum StatusRedacao {

	SEM_PROBLEMAS(1, "Sem problemas"), 
	ANULADA(2, "Anulada"), 
	COPIA(3, "Cópia Texto Motivador"), 
	EM_BRANCO(4, "Em Branco"), 
	FUGA_AO_TEMA(5, "Fuga ao tema"),
	TIPO_TEXTUAL(6, "Não atendimento ao tipo textual"),
	TEXTO_INSUFICIENTE(7, "Texto insuficiente"),
	PARTE_DESCONECTADA(8, "Parte desconectada");
	
	private int index;
	private String descricao;
	
	private StatusRedacao(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static StatusRedacao byIndex(String dataIndex) {
		if(!dataIndex.equals("")) {
			Integer index = Integer.valueOf(dataIndex);
			for (StatusRedacao n : StatusRedacao.values()) {
				if (n.index == index) {
					return n;
				}
			}
		}
		return null;

	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
