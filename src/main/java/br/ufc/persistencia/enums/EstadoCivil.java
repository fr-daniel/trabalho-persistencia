package br.ufc.persistencia.enums;

public enum EstadoCivil {

	SOLTEIRO(0, "Solteiro(a)"), 
	CASADO(1, "Casado(a)/Mora com companheiro(a)"), 
	DIVORCIADO(2, "Divorciado(a)/Desquitado(a)/Separado(a)"), 
	VIUVO(3, "Viúvo");
	
	private int index;
	private String descricao;
	
	private EstadoCivil(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}
	
	public static EstadoCivil byIndex(String dataIndex) {
		
		if (!dataIndex.equals("")) {
			Integer index = Integer.valueOf(dataIndex);
			for (EstadoCivil n : EstadoCivil.values()) {
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
