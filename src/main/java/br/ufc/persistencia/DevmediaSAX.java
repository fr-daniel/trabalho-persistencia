package br.ufc.persistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DevmediaSAX extends DefaultHandler {

	private String pathJson;
	
	private String tagAtual;
	
	private List<Candidato> candidatos;
	
	private Candidato candidatoAtual;
	private Redacao redacaoAtual;
	private NotasRedacao notasRedacaoAtual;
	private Prova provaAtual;

	public DevmediaSAX() {
		super();
		this.candidatos = new ArrayList<Candidato>();
	}

	public void fazerParsing(String pathArq, String pathJson) {
this.pathJson = pathJson;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;

		try {
			
			saxParser = factory.newSAXParser();
			saxParser.parse(pathArq, this);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void startDocument() {
	}

	public void endDocument() {
		System.out.println("\nFim do Parsing...");
		for (Candidato candidato : candidatos) {
			System.out.println(candidato);
		}
		
		salvarEmJSON();
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) {
		tagAtual = qName;
		
		switch (qName) {
		case "candidato":
			candidatoAtual = new Candidato();
			candidatoAtual.setInscricao(atts.getValue(0));
			candidatos.add(candidatoAtual);
			break;
		case "prova":
			provaAtual = new Prova();
			candidatoAtual.addProva(provaAtual);
			break;
		case "redacao":
			redacaoAtual = new Redacao();
			candidatoAtual.setRedacao(redacaoAtual);
			break;
		case "notas":
			notasRedacaoAtual = new NotasRedacao();
			redacaoAtual.setNotasRedacao(notasRedacaoAtual);
			break;
		default:
			break;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		tagAtual = "";
	}

	public void characters(char[] ch, int start, int length) throws SAXException {

		String texto = new String(ch, start, length);
		
		switch (tagAtual) {
		case "sexo":
			candidatoAtual.setSexo(texto);
			break;
		case "nacionalidade":
			candidatoAtual.setNacionalidade(texto);
			break;
		case "idade":
			candidatoAtual.setIdade(Integer.valueOf(texto));
			break;
		case "raca":
			candidatoAtual.setRaca(texto);
			break;
		case "estado_civil":
			candidatoAtual.setEstado_civil(texto);
			break;
		case "status":
			redacaoAtual.setStatus(texto);
			break;
		case "nota_final":
			redacaoAtual.setNotaFinal(texto);
			break;
		case "competencia_1":
			notasRedacaoAtual.setCompetencia_1(texto);
			break;
		case "competencia_2":
			notasRedacaoAtual.setCompetencia_2(texto);
			break;
		case "competencia_3":
			notasRedacaoAtual.setCompetencia_3(texto);
			break;
		case "competencia_4":
			notasRedacaoAtual.setCompetencia_4(texto);
			break;
		case "competencia_5":
			notasRedacaoAtual.setCompetencia_5(texto);
			break;
		case "descricao":
			provaAtual.setDescricao(texto);
			break;
		case "presenca":
			provaAtual.setPresenca(texto);
			break;
		case "nota":
			provaAtual.setNota(texto);
			break;
		default:
			break;
		}	
	}
	
	public void salvarEmJSON() {

		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File(pathJson), candidatos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}