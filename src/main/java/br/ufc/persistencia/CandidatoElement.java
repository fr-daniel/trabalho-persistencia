package br.ufc.persistencia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CandidatoElement {

	private static final int INDEX_NU_INSCRICAO = 0;
	private static final int INDEX_NU_IDADE = 6;
	private static final int INDEX_TP_SEXO = 7;
	private static final int INDEX_TP_ESTADO_CIVIL = 8;
	private static final int INDEX_TP_COR_RACA = 9;
	private static final int INDEX_TP_NACIONALIDADE = 10;

	public static Element create(Document doc, String[] data) {

		Element candidato = doc.createElement("candidato");
		candidato.setAttribute("inscricao", data[INDEX_NU_INSCRICAO]);

		candidato.appendChild(createElement(doc, "idade", data[INDEX_NU_IDADE]));

		addSexo(doc, candidato, data);
		addNacionalidade(doc, candidato, data);
		addRaca(doc, candidato, data);
		addEstadoCivil(doc, candidato, data);

		return candidato;
	}

	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	private static Element addSexo(Document doc, Element candidato, String[] data) {

		Sexo sexo = Sexo.byIndex(data[INDEX_TP_SEXO]);
		String sexoDesc = sexo != null ? sexo.getDescricao() : "";

		candidato.appendChild(createElement(doc, "sexo", sexoDesc));

		return candidato;
	}

	private static Element addNacionalidade(Document doc, Element candidato, String[] data) {

		Nacionalidade nacionalidade = Nacionalidade.byIndex(data[INDEX_TP_NACIONALIDADE]);
		String nacionalidadeDesc = nacionalidade != null ? nacionalidade.getDescricao() : "";

		candidato.appendChild(createElement(doc, "nacionalidade", nacionalidadeDesc));

		return candidato;
	}

	private static Element addEstadoCivil(Document doc, Element candidato, String[] data) {

		EstadoCivil estadoCivil = EstadoCivil.byIndex(data[INDEX_TP_ESTADO_CIVIL]);
		String estadoCivilDesc = estadoCivil != null ? estadoCivil.getDescricao() : "";

		candidato.appendChild(createElement(doc, "estado_civil", estadoCivilDesc));

		return candidato;
	}

	private static Element addRaca(Document doc, Element candidato, String[] data) {

		Raca raca = Raca.byIndex(data[INDEX_TP_COR_RACA]);
		String racaDesc = raca != null ? raca.getDescricao() : "";

		candidato.appendChild(createElement(doc, "raca", racaDesc));

		return candidato;
	}

}
