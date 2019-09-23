package br.ufc.persistencia.elements;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.ufc.persistencia.enums.StatusRedacao;

public class RedacaoElement {

	private static final int INDEX_TP_STATUS_REDACAO = 103;
	private static final int INDEX_NU_NOTA_COMP1 = 104;
	private static final int INDEX_NU_NOTA_COMP2 = 105;
	private static final int INDEX_NU_NOTA_COMP3 = 106;
	private static final int INDEX_NU_NOTA_COMP4 = 107;
	private static final int INDEX_NU_NOTA_COMP5 = 108;
	private static final int INDEX_NU_NOTA_REDACAO = 109;
	
	public static Element create(Document doc, String[] data) {

		Element redacao = doc.createElement("redacao");
		
		addStatus(doc, redacao, data);
		
		redacao.appendChild(createElement(doc, "nota_final", data[INDEX_NU_NOTA_REDACAO]));

		Element notas = doc.createElement("notas");
		notas.appendChild(createElement(doc, "competencia_1", data[INDEX_NU_NOTA_COMP1]));
		notas.appendChild(createElement(doc, "competencia_2", data[INDEX_NU_NOTA_COMP2]));
		notas.appendChild(createElement(doc, "competencia_3", data[INDEX_NU_NOTA_COMP3]));
		notas.appendChild(createElement(doc, "competencia_4", data[INDEX_NU_NOTA_COMP4]));
		notas.appendChild(createElement(doc, "competencia_5", data[INDEX_NU_NOTA_COMP5]));

		redacao.appendChild(notas);
		
		return redacao;
	}

	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
	
	private static Element addStatus(Document doc, Element redacao, String[] data) {

		StatusRedacao status = StatusRedacao.byIndex(data[INDEX_TP_STATUS_REDACAO]);
		String statusDesc = status != null ? status.getDescricao() : "";

		redacao.appendChild(createElement(doc, "status", statusDesc));

		return redacao;
	}
	
}
