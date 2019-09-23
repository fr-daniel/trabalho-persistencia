package br.ufc.persistencia.elements;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.ufc.persistencia.enums.PresencaProva;

public class ProvaObjetivaElement {

	private static final int INDEX_TP_PRESENCA_CN = 82;
	private static final int INDEX_TP_PRESENCA_CH = 83;
	private static final int INDEX_TP_PRESENCA_LC = 84;
	private static final int INDEX_TP_PRESENCA_MT = 85;
	private static final int INDEX_NU_NOTA_CN = 90;
	private static final int INDEX_NU_NOTA_CH = 91;
	private static final int INDEX_NU_NOTA_LC = 92;
	private static final int INDEX_NU_NOTA_MT = 93;

	public static Element create(Document doc, String[] data) {

		Element provaObjetiva = doc.createElement("provas");

		addProva(doc, provaObjetiva, "Ciências da Natureza", data[INDEX_TP_PRESENCA_CN], data[INDEX_NU_NOTA_CN]);
		addProva(doc, provaObjetiva, "Ciências Humanas", data[INDEX_TP_PRESENCA_CH], data[INDEX_NU_NOTA_CH]);
		addProva(doc, provaObjetiva, "Linguagens e Códigos", data[INDEX_TP_PRESENCA_LC], data[INDEX_NU_NOTA_LC]);
		addProva(doc, provaObjetiva, "Matemática", data[INDEX_TP_PRESENCA_MT], data[INDEX_NU_NOTA_MT]);

		return provaObjetiva;
	}

	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
	
	private static Element addProva(Document doc, Element provaObjetiva, String descProva, String indexPresenca, String nota) {

		Element prova = doc.createElement("prova");

		PresencaProva presenca = PresencaProva.byIndex(indexPresenca);
		String presencaDesc = presenca != null ? presenca.getDescricao() : "";
		
		System.out.println(indexPresenca + presencaDesc);

		prova.appendChild(createElement(doc, "descricao", descProva));
		prova.appendChild(createElement(doc, "presenca", presencaDesc));
		prova.appendChild(createElement(doc, "nota", nota));
		
		provaObjetiva.appendChild(prova);
		
		return provaObjetiva;
	}
	
}
